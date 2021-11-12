package com.blusmart.assignment.main.view;

import com.blusmart.assignment.di.mvp.MvpView;

import java.util.ArrayList;

public interface MainView extends MvpView {
    void getDutyListSuccess(ArrayList dutyListData);

    void showDutyDetailFragment(String id);

    void showToolBar(String all_duties);
}
