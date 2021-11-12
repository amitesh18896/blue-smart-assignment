package com.blusmart.assignment.base;

import com.blusmart.assignment.R;
import com.blusmart.assignment.di.mvp.MvpView;

public class BasePresenter <V extends MvpView> implements MvpPresenter<V>  {
    private static final String TAG = BasePresenter.class.getSimpleName();
    private V mMvpView;
    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    @Override
    public void handleApiError(Throwable error) {
        if (error == null ) {
            getMvpView().onError(R.string.api_default_error);
            return;
        }
        else {
            getMvpView().onError(error.getMessage());
        }
    }
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
