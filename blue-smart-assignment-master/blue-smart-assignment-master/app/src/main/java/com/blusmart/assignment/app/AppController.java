package com.blusmart.assignment.app;

import android.app.Application;

import com.blusmart.assignment.di.components.ApplicationComponent;
import com.blusmart.assignment.di.components.DaggerApplicationComponent;
import com.blusmart.assignment.di.module.ApplicationModule;

public class AppController extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        applicationComponent = applicationComponent;
    }


}
