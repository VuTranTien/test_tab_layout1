package com.example.test_tab_layout1.ui.recruiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.update_recInfoActivity;
import com.google.android.material.tabs.TabLayout;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class PageViewInform extends Fragment {
    public PageViewInform (){

    }
    Button btn_update_recInfo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inform,container,false);
        btn_update_recInfo = root.findViewById(R.id.btn_update_recInfo);
        btn_update_recInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), update_recInfoActivity.class);
                startActivity(it);
            }
        });
        TabLayout tl = root.findViewById(R.id.tabs);

        return root;
    }
}
