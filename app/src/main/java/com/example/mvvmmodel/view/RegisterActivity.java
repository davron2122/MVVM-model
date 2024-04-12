package com.example.mvvmmodel.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmmodel.R;
import com.example.mvvmmodel.base.BaseActivity;
import com.example.mvvmmodel.databinding.ActivityRegisterBinding;
import com.example.mvvmmodel.model.User;
import com.example.mvvmmodel.repository.remote.OnboardingApi;
import com.example.mvvmmodel.util.ApiService;
import com.example.mvvmmodel.util.PreferenceManager;
import com.example.mvvmmodel.util.ViewModelFactory;
import com.example.mvvmmodel.vm.OnboardingViewModel;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, OnboardingViewModel> {

    @Override
    protected ActivityRegisterBinding inflateView(LayoutInflater inflater) {
        return ActivityRegisterBinding.inflate(inflater);
    }

    @Override
    protected OnboardingViewModel getViewModel() {
        return new ViewModelProvider(this, new ViewModelFactory(ApiService.provideApi(OnboardingApi.class, RegisterActivity.this),
                PreferenceManager.getInstance(RegisterActivity.this))).get(OnboardingViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etEmail.getText().toString();
                String firstName = binding.etFirstName.getText().toString();
                String lastName = binding.etLastName.getText().toString();
                String password = binding.etPassword.getText().toString();
                String phoneNumber = binding.etPhoneNumber.getText().toString();
                String postCode = binding.tvPostCode.getText().toString();
                String address = binding.tvAddress.getText().toString();
                String addressDetails = binding.etAddressDetails.getText().toString();
                String full_address = "[" + postCode + "] " + address + ", " + addressDetails;
                User user = new User(email, password, firstName, lastName, phoneNumber, full_address);

                viewModel.createUser(user);

            }
        });

        binding.btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etEmail.getText().toString();
                String firstName = binding.etFirstName.getText().toString();
                String lastName = binding.etLastName.getText().toString();
                String password = binding.etPassword.getText().toString();
                String phoneNumber = binding.etPhoneNumber.getText().toString();
                String postCode = binding.tvPostCode.getText().toString();
                String address = binding.tvAddress.getText().toString();
                String addressDetails = binding.etAddressDetails.getText().toString();
                String full_address = "[" + postCode + "] " + address + ", " + addressDetails;
                User user = new User(email, password, firstName, lastName, phoneNumber, full_address);

                viewModel.createUser(user);
            }
        });

        viewModel.onUserCreated.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.etEmail.addTextChangedListener(viewModel.emailTextWatcher);
        viewModel.isEmailValid.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isEmailValid) {
                binding.icVerifiedEmail.setVisibility(isEmailValid ? View.VISIBLE : View.INVISIBLE);
            }
        });



    }

}
