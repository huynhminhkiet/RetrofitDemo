package com.example.minhkiet.retrofitdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by minhkiet on 25/11/2016
 */

public class StatusResponse {
    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
