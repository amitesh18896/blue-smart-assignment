package com.blusmart.assignment.splash;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.blusmart.assignment.R;
import com.blusmart.assignment.base.BaseActivity;
import com.blusmart.assignment.main.MainActivity;
import com.blusmart.assignment.splash.persenter.SplashPresenter;
import com.blusmart.assignment.splash.view.SplashView;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashView {
    private static final long Splash_TIME_DELEY = 1000;
    private static final int REQUEST_CODE = 123;
    @Inject
    SplashPresenter<SplashView> mPresenter;

    private static final String[] MUST_PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();
    }

    @Override
    protected void setUp() {
        if (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            mPresenter.onAttach(SplashActivity.this);
        } else {
            requestPermissionsSafely(MUST_PERMISSIONS, REQUEST_CODE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            mPresenter.onAttach(SplashActivity.this);
        }
    }

    @Override
    public void openLoginActivity() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = MainActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();
            }
        };
        Timer t = new Timer();
        t.schedule(task, Splash_TIME_DELEY);
    }
}
