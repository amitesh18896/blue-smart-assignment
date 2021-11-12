package com.blusmart.assignment.duty.view;


import com.blusmart.assignment.di.mvp.MvpView;
import com.blusmart.assignment.duty.model.ModelForDutyDetail;

public interface DutyDetailView extends MvpView {
    void getDutyDetailSuccess(ModelForDutyDetail dutyListView);

    void updateDutySuccess(ModelForDutyDetail dutyListView);
}
