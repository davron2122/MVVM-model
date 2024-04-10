package com.example.mvvmmodel.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmmodel.repository.remote.OnboardingApi;
import com.example.mvvmmodel.vm.OnboardingViewModel;

public class ViewModelFactory  extends ViewModelProvider.NewInstanceFactory {

    Object[] params;

    public ViewModelFactory() {
        this.params=null;
    }


    public ViewModelFactory(Object...params) {
        this.params = params;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(OnboardingViewModel.class)) {
           return(T) new OnboardingViewModel((OnboardingApi) params[0]);
        }

        return super.create(modelClass);
    }
}

