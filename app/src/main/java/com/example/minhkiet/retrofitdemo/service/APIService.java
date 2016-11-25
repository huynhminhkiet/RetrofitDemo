package com.example.minhkiet.retrofitdemo.service;

import com.example.minhkiet.retrofitdemo.model.City;
import com.example.minhkiet.retrofitdemo.model.ContactResponse;
import com.example.minhkiet.retrofitdemo.model.StatusResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by minhkiet on 21/11/2016
 */

public interface APIService {
    @GET("/contacts")
    Call<ContactResponse> getContactList();

    @POST("/cities")
    Call<StatusResponse> createUser(@Body City city);
}
