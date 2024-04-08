package com.example.mvvmmodel.view;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.example.mvvmmodel.R;
import com.example.mvvmmodel.base.BaseActivity;
import com.example.mvvmmodel.databinding.ActivityRegisterBinding;
import com.example.mvvmmodel.vm.OnboardingViewModel;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, OnboardingViewModel> {





    @Override
    protected ActivityRegisterBinding inflateView(LayoutInflater inflater) {
        return ActivityRegisterBinding.inflate(inflater);
    }

    @Override
    protected OnboardingViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
