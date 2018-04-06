package com.example.quagnitia.eventwebservicedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    Context context = this;
    ListView lvEvent;
    ArrayList<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        initUi();
    }

    private void initUi() {
        lvEvent = findViewById(R.id.lvEvent);
    }
}
