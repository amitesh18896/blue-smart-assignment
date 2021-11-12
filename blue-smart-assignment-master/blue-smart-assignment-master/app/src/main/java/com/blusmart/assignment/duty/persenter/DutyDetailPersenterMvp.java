package com.blusmart.assignment.duty.persenter;

import com.blusmart.assignment.api.RetrofitImp;
import com.blusmart.assignment.base.BasePresenter;
import com.blusmart.assignment.duty.model.ModelForDutyDetail;
import com.blusmart.assignment.duty.view.DutyDetailView;
import java.util.Map;
import javax.inject.Inject;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class DutyDetailPersenterMvp  <V extends DutyDetailView> extends BasePresenter<V> implements DutyDetailPersenter<V> {

    @Inject
    public DutyDetailPersenterMvp() {
        super();
    }


    @Inject
    RetrofitImp  retrofitImp;


    @Override
    public void getDutyDetail(String id, String checksum) {
        getMvpView().showLoading();
        retrofitImp.getRetrofitServices().getDutyDetail(id,"no-cache",checksum)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(retrofitImp.defaultSubscribeScheduler())
                .subscribe(new Subscriber<ModelForDutyDetail>() {
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
                    public void onNext( ModelForDutyDetail  modelForDutyDetail) {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        getMvpView().getDutyDetailSuccess(modelForDutyDetail);
                    }
                });
    }

    @Override
    public void updateDuty(String id, Map<String, String> requestBody, String checksumforUpdate) {
        getMvpView().showLoading();
        retrofitImp.getRetrofitServices().updateDuty(id,"no-cache",checksumforUpdate,requestBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(retrofitImp.defaultSubscribeScheduler())
                .subscribe(new Subscriber<ModelForDutyDetail>() {
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
                    public void onNext( ModelForDutyDetail  modelForDutyDetail) {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        getMvpView().updateDutySuccess(modelForDutyDetail);
                    }
                });
    }
}
