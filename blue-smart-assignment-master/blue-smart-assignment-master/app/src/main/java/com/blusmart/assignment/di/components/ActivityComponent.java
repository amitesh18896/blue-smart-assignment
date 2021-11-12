package com.blusmart.assignment.di.components;


import com.blusmart.assignment.api.RetrofitImp;
import com.blusmart.assignment.di.PerActivity;
import com.blusmart.assignment.di.module.ActivityModule;
import com.blusmart.assignment.duty.DutyDetailFragment;
import com.blusmart.assignment.main.MainActivity;
import com.blusmart.assignment.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(RetrofitImp retrofitImp);

    void inject(SplashActivity activity);

    void inject(DutyDetailFragment fragment);


}
