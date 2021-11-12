package com.blusmart.assignment.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.blusmart.assignment.api.RetrofitImp;
import com.blusmart.assignment.di.ActivityContext;
import com.blusmart.assignment.di.PerActivity;
import com.blusmart.assignment.duty.persenter.DutyDetailPersenter;
import com.blusmart.assignment.duty.persenter.DutyDetailPersenterMvp;
import com.blusmart.assignment.duty.view.DutyDetailView;
import com.blusmart.assignment.main.adapter.DutyListAdapter;
import com.blusmart.assignment.main.persenter.MainMvpPersenter;
import com.blusmart.assignment.main.persenter.MainPersenter;
import com.blusmart.assignment.main.view.MainView;
import com.blusmart.assignment.splash.persenter.SplashMvpPresenter;
import com.blusmart.assignment.splash.persenter.SplashPresenter;
import com.blusmart.assignment.splash.view.SplashView;
import com.blusmart.assignment.utility.GenrateChecksum;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }


    @Provides
    @PerActivity
    SplashPresenter<SplashView> provideSplashPresenter(
            SplashMvpPresenter<SplashView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    MainPersenter<MainView> providedutyListPresenter(
            MainMvpPersenter<MainView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    DutyDetailPersenter<DutyDetailView> providdetailPresenter(
            DutyDetailPersenterMvp<DutyDetailView> presenter) {
        return presenter;
    }


    @Provides
    DutyListAdapter provideDutyAdapter() {
        return new DutyListAdapter();
    }

    @Provides
    GenrateChecksum providecheckSum() {
        return new GenrateChecksum();
    }

    @Provides
    RetrofitImp provideretrofit() {
        return new RetrofitImp();
    }



}
