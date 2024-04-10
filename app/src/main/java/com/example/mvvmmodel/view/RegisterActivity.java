package com.example.mvvmmodel.view;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmmodel.R;
import com.example.mvvmmodel.base.BaseActivity;
import com.example.mvvmmodel.databinding.ActivityRegisterBinding;
import com.example.mvvmmodel.repository.remote.OnboardingApi;
import com.example.mvvmmodel.util.ApiService;
import com.example.mvvmmodel.util.ViewModelFactory;
import com.example.mvvmmodel.vm.OnboardingViewModel;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, OnboardingViewModel> {

    @Override
    protected ActivityRegisterBinding inflateView(LayoutInflater inflater) {
        return ActivityRegisterBinding.inflate(inflater);
    }

    @Override
    protected OnboardingViewModel getViewModel() {
        return new  ViewModelProvider(this,OnboardingViewModel ).get(RegisterActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
