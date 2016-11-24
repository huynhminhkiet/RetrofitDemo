package com.example.minhkiet.retrofitdemo.service;

import com.example.minhkiet.retrofitdemo.model.ContactResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by minhkiet on 21/11/2016
 */

public interface APIService {
    @GET("contacts")
    Call<ContactResponse> getContactList();
}
