package com.example.test_tab_layout1.ui.jobseeker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ViewHocVanList.HocVanAdapter;
import com.example.test_tab_layout1.ViewHocVanList.HocVanInfo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 05, December,2019
 **/
public class PageViewHoSo extends Fragment {

    HocVanAdapter hocVanAdapter;
    RecyclerView recyclerView;
    List<HocVanInfo> hocVanInfoList = new ArrayList<>();

    public PageViewHoSo(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_hoso,container,false);
        View root = inflater.inflate(R.layout.fragment_baidang,container,false);
        recyclerView = root.findViewById(R.id.RC_congviec);

        TabLayout tl = root.findViewById(R.id.tabs);
//        tl.getTabAt(2);
        hocVanAdapter = new HocVanAdapter(hocVanInfoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(hocVanAdapter);
        loaddata();

        return root;
    }
    private void loaddata(){
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanInfoList.add(new HocVanInfo("DHBK","001","2021","Khoa học máy tính"));
        hocVanAdapter.notifyDataSetChanged();

    }
}
