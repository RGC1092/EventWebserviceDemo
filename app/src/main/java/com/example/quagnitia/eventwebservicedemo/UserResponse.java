package com.example.quagnitia.eventwebservicedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V@iBh@V on 3/21/2018.
 */

public class UserResponse {
    String status="";
    List<ResponseData> response=new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResponseData> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseData> response) {
        this.response = response;
    }
}
