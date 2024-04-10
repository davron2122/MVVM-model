package com.example.mvvmmodel.repository;

import com.example.mvvmmodel.model.User;
import com.example.mvvmmodel.repository.remote.OnboardingApi;
import com.example.mvvmmodel.util.RequestCallback;

import retrofit2.Call;
import retrofit2.Response;

public class OnboardingRepository {

    private OnboardingApi onboardingApi;

    public  OnboardingRepository(OnboardingApi onboardingApi){
     this.onboardingApi=onboardingApi;
    }

    public void createUser(User user){
        onboardingApi.createUser(user).enqueue(new RequestCallback<User>() {
            @Override
            protected void onResponseSuccess(Call<User> call, Response<User> response) {

            }

            @Override
            protected void onResponseFailed(Call<User> call, Throwable t) {

            }
        });

    }
}
