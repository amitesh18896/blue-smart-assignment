package com.blusmart.assignment.di.components;

import android.content.Context;

import com.blusmart.assignment.app.AppController;
import com.blusmart.assignment.di.ApplicationContext;
import com.blusmart.assignment.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(AppController appController);
    @ApplicationContext
    Context context();
}
