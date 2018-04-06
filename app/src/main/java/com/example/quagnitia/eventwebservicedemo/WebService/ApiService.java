package com.example.quagnitia.eventwebservicedemo.WebService;

import com.example.quagnitia.eventwebservicedemo.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by V@iBh@V on 3/21/2018.
 */

public interface ApiService {
    @Headers({
            "Accept:apllictaion/json",
            "Content/Type:apllication/json"
    })

    @GET("upcoming_events.json?dl=1")
    Call<UserResponse> getEventApi();
}
