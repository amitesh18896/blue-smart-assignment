package com.blusmart.assignment.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blusmart.assignment.R;
import com.blusmart.assignment.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DutyListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ArrayList dutyListData;
    private static ClickListener clickListener;

    public DutyListAdapter() {
        dutyListData = new ArrayList();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_duty, parent, false);
        return new DutyListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, final int position) {
        ((DutyListViewHolder) viewHolder).bind(dutyListData.get(position));
    }

    @Override
    public int getItemCount() {
        return dutyListData.size();
    }

    public void setTracks(ArrayList dutyListData) {
        this.dutyListData = dutyListData;
    }


    public class DutyListViewHolder extends BaseViewHolder{
        @BindView(R.id.txt_duty_title)
        TextView TitletxtDuty;
        @BindView(R.id.lay)
        LinearLayout lay;

        DutyListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @Override
        protected void clear() {

        }

        void bind(final Object dutyListBeans) {
            String id = String.valueOf(dutyListBeans);
            final String duty_id = id.replaceAll(".0", "");
            TitletxtDuty.setText(duty_id);
            lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(duty_id);
                }
            });
        }
    }
    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(String id);
    }

}
