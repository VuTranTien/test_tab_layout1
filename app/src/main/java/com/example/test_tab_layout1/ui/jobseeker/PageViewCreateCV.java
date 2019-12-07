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
public class PageViewCreateCV extends Fragment {
    public PageViewCreateCV() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_taocv,container,false);
        View root = inflater.inflate(R.layout.fragment_taocv,container,false);

        final TabLayout tl = root.findViewById(R.id.tabs);
        

        return root;
    }
}
