package com.example.quagnitia.eventwebservicedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.quagnitia.eventwebservicedemo.WebService.ApiService;
import com.example.quagnitia.eventwebservicedemo.WebService.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
   
    Context context = this;
    LinearLayout llContents;
    ListView lvEvent;
    //ArrayList<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

        initListener();
        getEventWs();
    }

    private void getEventWs() {
/*
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
*/

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<UserResponse> call = apiService.getEventApi();
        Log.i("@shradha","Url: "+call.request().url().toString());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.i("@shradha","Resp: "+response);

//                UserResponse responseObj = response.body();
//                if (response.body().getStatus().equals("SUCCESS")) {
//                    ArrayList<Event> eventList=new ArrayList<>();

                  //  for (int i=0;i<response.body().getResponse().size();i++)
//                    {
                        EventAdapter ed=new EventAdapter(context,response.body().getResponse());
                        lvEvent.setAdapter(ed);
//                    }
//                } else  {
//                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.i("@shradha","Error: "+t);
            }
        });
/*
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, UserResponse<UserResponse> response) {
                Log.i("@sandy", "Resp: " + response);
                progressDialog.dismiss();

                UserResponse responseObj = response.body();
                if (responseObj.equals("0")) {
                    ArrayList<Event> eventList=new ArrayList<>();

                    for (int i=0;i<responseObj.getResponse().size();i++)
                    {
                        EventAdapter ed=new EventAdapter(context,eventList);
                        lvEvent.setAdapter(ed);
                    }
                } else if (responseObj.equals("1")) {

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
*/
    }
/*
private Event eventUser()
{
    Event event=new Event();
    event.setEvent_title("hello1bsgsbbhahshs");
    event.setId("16");
    event.setVenue("9-13 Beco dos Anjos, マカオ, 9 Beco dos Anjos, Macau");
    event.setStart_time("2017-01-05 13:03:15");
    event.setEnd_time("2021-02-05 01:04:03");
    event.setTimezone("Asia/Kolkata");
    return event;

}
*/
    private void initListener() {
        llContents.setOnClickListener(this);
    }

    private void initUi() {
        llContents = findViewById(R.id.llContents);
        lvEvent = findViewById(R.id.lvEvent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llContents:
                Intent i = new Intent(context, EventActivity.class);
                startActivity(i);
                break;
        }
    }
}
