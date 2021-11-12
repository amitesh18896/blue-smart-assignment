package com.blusmart.assignment.splash.persenter;

import com.blusmart.assignment.base.BasePresenter;
import com.blusmart.assignment.splash.view.SplashView;

import javax.inject.Inject;

public class SplashMvpPresenter<V extends SplashView> extends BasePresenter<V>  implements SplashPresenter<V> {

    @Inject
    public SplashMvpPresenter() {
        super();
    }
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getMvpView().openLoginActivity();
    }
}
