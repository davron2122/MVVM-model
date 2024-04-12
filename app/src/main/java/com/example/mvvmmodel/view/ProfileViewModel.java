package com.example.mvvmmodel.view;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmmodel.base.BaseViewModel;
import com.example.mvvmmodel.model.User;
import com.example.mvvmmodel.repository.OnboardingRepository;

public class ProfileViewModel extends BaseViewModel {

    private OnboardingRepository onboardingRepository;


    public void updateUser(){

        onboardingRepository.updateUser(new User(), new MutableLiveData<>());
    }
}