package com.blusmart.assignment.duty.persenter;

import com.blusmart.assignment.base.MvpPresenter;
import com.blusmart.assignment.di.PerActivity;
import com.blusmart.assignment.duty.view.DutyDetailView;

import java.util.Map;

@PerActivity
public  interface DutyDetailPersenter  <V extends DutyDetailView> extends MvpPresenter<V>
{
    void getDutyDetail(String id, String checksum);

    void updateDuty(String id, Map<String, String> requestBody, String checksumforUpdate);
}
