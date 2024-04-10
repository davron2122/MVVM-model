package com.example.mvvmmodel.repository.remote;


import com.example.mvvmmodel.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OnboardingApi {

    @POST("/v1/login/")
    Call<User> login(@Body User user);

    @POST("v1/user/")
    Call<User> createUser(@Body User user);
}
