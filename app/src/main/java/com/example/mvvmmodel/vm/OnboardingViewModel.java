package com.example.mvvmmodel.vm;


import android.text.Editable;
import android.text.TextWatcher;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmmodel.base.BaseViewModel;
import com.example.mvvmmodel.model.User;
import com.example.mvvmmodel.repository.OnboardingRepository;
import com.example.mvvmmodel.repository.remote.OnboardingApi;
import com.example.mvvmmodel.util.PreferenceManager;

public class OnboardingViewModel extends BaseViewModel {

    OnboardingRepository onboardingRepository;

    public MutableLiveData<User> onUserCreated = new MutableLiveData<>();
    public MutableLiveData<Boolean> isEmailValid = new MutableLiveData<>();

    private User user;


    public OnboardingViewModel(OnboardingApi onboardingApi, PreferenceManager preferenceManager) {
        this.onboardingRepository = new OnboardingRepository(onboardingApi, preferenceManager);
        user = new User();
    }


    public TextWatcher emailTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String email = s.toString();
            boolean isValid = isEmailValid(email);
            isEmailValid.setValue(isValid);
            if (isValid)
                user.setEmail(email);
        }
    };


    private boolean isEmailValid(String email) {
        boolean isValid = false;
        if (email.contains("@") && email.indexOf('@') != 0) {
            String tail = email.substring(email.indexOf('@'));
            if (tail.contains(".")
                    && tail.indexOf('.') != 1
                    && email.lastIndexOf('.') != (email.length() - 1)) {
                isValid = true;
            }
        }

        return isValid;
    }

    public void createUser(User user) {
        onboardingRepository.createUser(user, onUserCreated);
    }
}
