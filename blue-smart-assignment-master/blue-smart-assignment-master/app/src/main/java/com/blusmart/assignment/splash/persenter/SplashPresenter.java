package com.blusmart.assignment.splash.persenter;

import com.blusmart.assignment.base.MvpPresenter;
import com.blusmart.assignment.di.PerActivity;
import com.blusmart.assignment.splash.view.SplashView;

@PerActivity
public interface SplashPresenter<V extends SplashView> extends MvpPresenter<V> {
    void onAttach(V mvpView);
}
