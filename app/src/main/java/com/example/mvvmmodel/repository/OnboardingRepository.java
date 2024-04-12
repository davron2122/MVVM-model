package com.example.mvvmmodel.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmmodel.model.User;
import com.example.mvvmmodel.repository.remote.OnboardingApi;
import com.example.mvvmmodel.util.PreferenceManager;
import com.example.mvvmmodel.util.RequestCallback;

import retrofit2.Call;
import retrofit2.Response;

public class OnboardingRepository {

    private OnboardingApi onboardingApi;

    private PreferenceManager preferenceManager;

    public OnboardingRepository(OnboardingApi onboardingApi, PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
        this.onboardingApi = onboardingApi;
    }


    public void createUser(User user, MutableLiveData<User> onUserCreated) {


        onboardingApi.createUser(user).enqueue(new RequestCallback<User>() {
            @Override
            protected void onResponseSuccess(Call<User> call, Response<User> response) {
                User created = response.body();
                preferenceManager.setValue("isLoggedIn", true);
                preferenceManager.setValue("user", created);
                preferenceManager.setValue("access_token", created.getAccessToken());
                onUserCreated.setValue(created);
            }

            @Override
            protected void onResponseFailed(Call<User> call, Throwable t) {

            }
        });
    }

    public void updateUser(User user, MutableLiveData<User> onUserUpdated) {
        onboardingApi.updateUser(1, user).enqueue(new RequestCallback<User>() {
            @Override
            protected void onResponseSuccess(Call<User> call, Response<User> response) {
                User created = response.body();
                preferenceManager.setValue("isLoggedIn", true);
                preferenceManager.setValue("user", created);
                preferenceManager.setValue("access_token", created.getAccessToken());
                onUserUpdated.setValue(created);
            }

            @Override
            protected void onResponseFailed(Call<User> call, Throwable t) {

            }
        });
    }
}
