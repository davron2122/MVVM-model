package com.example.mvvmmodel.util;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class CustomTextWatcher implements TextWatcher {

    Type type;

    public CustomTextWatcher(Type type) {
        this.type = type;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        afterTextChanged(s.toString(), type);
    }

    protected abstract void afterTextChanged(String text, Type type);

    public enum Type {
        EMAIL, FIRST_NAME, LAST_NAME, PHONE_NUMBER, PASSWORD, CONFIRM_PASSWORD, POST_CODE, ADDRESS, ADDRESS_DETAILS,
    }
}
