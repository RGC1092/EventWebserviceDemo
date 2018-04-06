package com.example.quagnitia.eventwebservicedemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by V@iBh@V on 4/2/2018.
 */

public class ResponseData {
    @SerializedName("Event")
    @Expose
    Event event=new Event();

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
