package com.blusmart.assignment.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.blusmart.assignment.R;
import com.blusmart.assignment.base.BaseActivity;
import com.blusmart.assignment.duty.DutyDetailFragment;
import com.blusmart.assignment.main.adapter.DutyListAdapter;
import com.blusmart.assignment.main.persenter.MainMvpPersenter;
import com.blusmart.assignment.main.view.MainView;
import com.blusmart.assignment.utility.FragmentManagerUtil;
import com.blusmart.assignment.utility.GenrateChecksum;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView ,DutyListAdapter.ClickListener {
    @Inject
    MainMvpPersenter<MainView> mPresenter;

    @Inject
    DutyListAdapter adapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @Inject
    GenrateChecksum genrateChecksum;

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.dutyList)
    RecyclerView recy_dutyList;
    @BindView(R.id.content_layout)
    CoordinatorLayout contentLayout;
    @BindView(R.id.container)
    ConstraintLayout container;
    private String toolBarTitle;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(MainActivity.this);
        mPresenter.getDutyList(genrateChecksum.checksumForList());
        setUp();
        mPresenter.setToolBarTitle(getResources().getString(R.string.allDuty));
    }


    @Override
    protected void setUp() {
        setSupportActionBar(toolbar);

        adapter.setOnItemClickListener(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_dutyList.setLayoutManager(mLayoutManager);
        recy_dutyList.setItemAnimator(new DefaultItemAnimator());
        recy_dutyList.setAdapter(adapter);

    }

    @Override
    public void getDutyListSuccess(ArrayList dutyListData) {
        recy_dutyList.getAdapter();
        adapter.setTracks(dutyListData);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDutyDetailFragment(String id) {
        FragmentManagerUtil.replaceFragment(getSupportFragmentManager(), R.id.content_layout,
                DutyDetailFragment.newInstance(id), true, DutyDetailFragment.TAG);

    }

    @Override
    public void showToolBar(String barTitle) {
        getSupportActionBar().setTitle("");
        title.setText(barTitle);
    }

    @Override
    public void onItemClick(String id) {
        mPresenter.onDutyAdapterClick(id);
        mPresenter.setToolBarTitle(getResources().getString(R.string.dutylist));
    }
}
