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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_layout1.App;
import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ViewAccountList.AccountAdapter;
import com.example.test_tab_layout1.ViewAccountList.AccountInfo;
import com.example.test_tab_layout1.ViewCompanyList.CompanyAdapter;
import com.example.test_tab_layout1.update_recInfoActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class PageViewInform extends Fragment {
    public PageViewInform (){

    }
    private AccountAdapter accountAdapter;
    private RecyclerView recyclerView;
    List<AccountInfo> accountInfoList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_baidang,container,false);

        recyclerView = root.findViewById(R.id.RC_congviec);
        TabLayout tl = root.findViewById(R.id.tabs);
        accountAdapter = new AccountAdapter(App.acounts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(accountAdapter);
        loaddata();

        return root;
    }
    private void loaddata(){
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountInfoList.add(new AccountInfo("vutrntin","123456","vutrntin2@gmail.com","Trần Tiến","Vũ","099999999","ktx","1","001"));
        accountAdapter.notifyDataSetChanged();
    }
}
