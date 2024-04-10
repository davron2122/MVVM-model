package com.example.mvvmmodel.vm;


import com.example.mvvmmodel.base.BaseViewModel;
import com.example.mvvmmodel.repository.OnboardingRepository;
import com.example.mvvmmodel.repository.remote.OnboardingApi;

public class OnboardingViewModel extends BaseViewModel {

    OnboardingRepository onboardingRepository;

    public OnboardingViewModel(OnboardingApi onboardingApi) {
        this.onboardingRepository = new OnboardingRepository(onboardingApi);
    }
}
