package com.example.test_tab_layout1.ui.jobseeker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ThongtincongtyActivity;
import com.example.test_tab_layout1.ViewJobList.JobAdapter;
import com.example.test_tab_layout1.ViewJobList.jobInfo;
import com.example.test_tab_layout1.thongtincongviecActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 05, December,2019
 **/
public class PageViewCongViec extends Fragment {

    private List<jobInfo> jobInfoList = new ArrayList<>();
    RecyclerView recyclerView;

    private JobAdapter jobAdapter;
//    Context des_context = getActivity();


    public PageViewCongViec(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_congviec,container,false);

//        tl = root.findViewById(R.id.tabs);
//        txt_thongtincongty = root.findViewById(R.id.txt_thongtincongty);
//        txt_tenvieclam = root.findViewById(R.id.txt_tenvieclam);
//        txt_thoihantuyen= root.findViewById(R.id.txt_thoihantuyen);
//        txt_luong= root.findViewById(R.id.txt_luong);
//        txt_gioitinh = root.findViewById(R.id.txt_gioitinh);
//        txt_chucvu = root.findViewById(R.id.txt_chucvu);
//        txt_kinhnghiem = root.findViewById(R.id.txt_kinhnghiemyeucau);
//        txt_diadiemlamviec = root.findViewById(R.id.txt_diadiemlamviec);
//        txt_motacongviec = root.findViewById(R.id.txt_motacongviec);
//        txt_yeucaucongviec = root.findViewById(R.id.txt_yeucaucongviecc);
//        txt_quyenloi = root.findViewById(R.id.txt_quyenloi);
//        txt_thongtincongty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent it = new Intent(getActivity(), ThongtincongtyActivity.class);
//                it.putExtra("ten_cong_ty",txt_thongtincongty.getText());
//
//                startActivity(it);
//            }
//        });

        recyclerView = root.findViewById(R.id.RC_congviec);
        jobAdapter = new JobAdapter(jobInfoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobAdapter);
        loaddata();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        
    }
    void loaddata(){
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobInfoList.add(new jobInfo("1234","Android DEV","2000$","TP HCM","20/1/2020","ABC"));
        jobAdapter.notifyDataSetChanged();


    }


    
}
