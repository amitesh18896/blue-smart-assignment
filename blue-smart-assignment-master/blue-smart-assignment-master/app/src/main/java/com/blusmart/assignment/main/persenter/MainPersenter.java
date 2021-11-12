package com.blusmart.assignment.main.persenter;

import com.blusmart.assignment.base.MvpPresenter;
import com.blusmart.assignment.di.PerActivity;
import com.blusmart.assignment.main.view.MainView;


@PerActivity
public interface MainPersenter <V extends MainView> extends MvpPresenter<V>
{

    void getDutyList(String checksumForList);

    void onDutyAdapterClick(String id);

    void setToolBarTitle(String barTitle);
}
