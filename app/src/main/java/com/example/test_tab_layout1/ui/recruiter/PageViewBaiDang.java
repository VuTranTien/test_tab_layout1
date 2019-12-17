package com.example.test_tab_layout1.ui.recruiter;

import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_layout1.App;
import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ViewJobList.JobAdapter;
import com.example.test_tab_layout1.ViewJobList.RecJobAdapter;
import com.example.test_tab_layout1.ViewJobList.jobInfo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class PageViewBaiDang extends Fragment {
    public PageViewBaiDang (){

    }
    private List<jobInfo> jobInfoList = new ArrayList<>();
    RecyclerView recyclerView;

    private RecJobAdapter jobAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_baidang,container,false);

        TabLayout tl = root.findViewById(R.id.tabs);

        recyclerView = root.findViewById(R.id.RC_congviec);
        jobAdapter = new RecJobAdapter(App.jobs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobAdapter);
        loaddata();

        EditText edt = root.findViewById(R.id.edtTimKiem);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
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
