package com.example.mvvmmodel.base;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

public abstract  class BaseActivity <VB extends ViewBinding, VM extends BaseViewModel> {

    VB binding;
    VM viewModel;

    protected abstract VB inflateView(LayoutInflater inflater);

    protected abstract VM getViewModel();


}






