package com.blusmart.assignment.duty;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blusmart.assignment.R;
import com.blusmart.assignment.base.BaseFragment;
import com.blusmart.assignment.di.components.ActivityComponent;
import com.blusmart.assignment.duty.model.ModelForDutyDetail;
import com.blusmart.assignment.duty.persenter.DutyDetailPersenter;
import com.blusmart.assignment.duty.view.DutyDetailView;
import com.blusmart.assignment.utility.Constants;
import com.blusmart.assignment.utility.DialogUtils;
import com.blusmart.assignment.utility.GenrateChecksum;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import im.delight.android.location.SimpleLocation;

public class DutyDetailFragment extends BaseFragment implements DutyDetailView {
    public static final String TAG = DutyDetailFragment.class.getSimpleName();
    @Inject
    DutyDetailPersenter<DutyDetailView> mPresenter;

    @Inject
    GenrateChecksum genrateChecksum;

    @BindView(R.id.txtforassigned)
    TextView txtforassigned;
    @BindView(R.id.txtforid)
    TextView txtforid;
    @BindView(R.id.txtforstate)
    TextView txtforstate;
    @BindView(R.id.txtfortype)
    TextView txtfortype;
    @BindView(R.id.layUpdate)
    LinearLayout layUpdate;
    private String assigned;
    private String type;
    private String state;
    private String action;
    private String id;
    private SimpleLocation location;
    private double latitude;
    private double longitude;
    private long timestamp;

    public static DutyDetailFragment newInstance(String id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DUTY_ID, id);
        DutyDetailFragment fragment = new DutyDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_duty_detail, container, false);
        Bundle bundle = this.getArguments();
        id = bundle.getString(Constants.DUTY_ID, "");
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mPresenter.getDutyDetail(id, genrateChecksum.checksumForDutyId(id));
        }
        // construct a new instance of SimpleLocation
        location = new SimpleLocation(getActivity());
        return view;
    }


    @Override
    protected void setUp(View view) {
    }

    @Override
    public void getDutyDetailSuccess(ModelForDutyDetail dutyListView) {
        setDutyDetailData(dutyListView);
    }


    @Override
    public void updateDutySuccess(ModelForDutyDetail dutyListView) {
        setDutyDetailData(dutyListView);
    }

    private void setDutyDetailData(ModelForDutyDetail dutyListView) {
        assigned = dutyListView.getAssigned();
        type = dutyListView.getType();
        id = String.valueOf(dutyListView.getId());
        state = dutyListView.getState();
        txtforassigned.setText(assigned);
        txtforid.setText(id);
        txtforstate.setText(state);
        txtfortype.setText(type);
        actionType(state);
    }


    private void actionType(String dutyListView) {
        switch (dutyListView) {
            case Constants.START:
                action = Constants.IN_PROGRESS;
                break;
            case Constants.IN_PROGRESS:
                action = Constants.COMPLETE;
                break;
            case Constants.PLANNED:
                action = Constants.START;
                break;
            case Constants.COMPLETED:
                action = "";
                break;
        }
    }

    @OnClick(R.id.layUpdate)
    public void onViewClicked() {
        if (!action.equals("")) {
            DialogUtils.showDialog(getActivity(), getResources().getString(R.string.update), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    timestamp = System.currentTimeMillis();
                    mPresenter.updateDuty(id, rawData(action, assigned, latitude, longitude, timestamp), genrateChecksum.checksumForUpdateDuty(id, action, assigned, latitude, longitude, timestamp, Constants.USER));
                }
            }).show();
        } else {
            DialogUtils.showDialog(getActivity(), getResources().getString(R.string.complete)).show();
        }
    }

    private Map<String, String> rawData(String action, String assigned, Double latitude, Double longitude, long timestamp) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("action", action);
        requestBody.put("assigned", assigned);
        requestBody.put("latitude", String.valueOf(latitude));
        requestBody.put("longitude", String.valueOf(longitude));
        requestBody.put("timestamp", String.valueOf(timestamp));
        requestBody.put("user", Constants.USER);
        return requestBody;
    }

    @Override
    public void onResume() {
        super.onResume();
        // if we can't access the location yet

        if (!location.hasLocationEnabled()) {
            // ask the user to enable location access
            SimpleLocation.openSettings(getActivity());
        }
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        location.beginUpdates();
    }

    @Override
    public void onPause() {
        // stop location updates (saves battery)
        location.endUpdates();
        super.onPause();
    }
}
