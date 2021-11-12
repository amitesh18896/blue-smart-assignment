package com.blusmart.assignment.main.persenter;
import com.blusmart.assignment.api.RetrofitImp;
import com.blusmart.assignment.base.BasePresenter;
import com.blusmart.assignment.main.view.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainMvpPersenter <V extends MainView> extends BasePresenter<V> implements MainPersenter<V>{
    @Inject
    public MainMvpPersenter() {
        super();
    }

    @Inject
    RetrofitImp retrofitImp;


    @Override
    public void getDutyList(String checksum) {
        getMvpView().showLoading();
        retrofitImp.getRetrofitServices().getDutyList("no-cache",checksum)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(retrofitImp.defaultSubscribeScheduler())
                .subscribe(new Subscriber< Object  >() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        handleApiError(e);
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext( Object   response) {
                        if (!isViewAttached()) {
                            return;
                        }
                        ArrayList dutyListData = (ArrayList) response;
                        getMvpView().hideLoading();
                        getMvpView().getDutyListSuccess(dutyListData);
                    }
                });
    }

    @Override
    public void onDutyAdapterClick(String id) {
        getMvpView().showDutyDetailFragment(id);
    }

    @Override
    public void setToolBarTitle(String barTitle) {
        getMvpView().showToolBar(barTitle);
    }
}

