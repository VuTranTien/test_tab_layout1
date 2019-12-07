package com.example.test_tab_layout1.ui.jobseeker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test_tab_layout1.R;
import com.google.android.material.tabs.TabLayout;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 05, December,2019
 **/
public class PageViewHoSo extends Fragment {

    public PageViewHoSo(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_hoso,container,false);
        View root = inflater.inflate(R.layout.fragment_hoso,container,false);

        TabLayout tl = root.findViewById(R.id.tabs);
//        tl.getTabAt(2);

        return root;
    }
}
