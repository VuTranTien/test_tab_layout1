package com.example.test_tab_layout1.ui.recruiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_layout1.App;
import com.example.test_tab_layout1.ConnectToSQLServer;
import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ViewAccountList.AccountAdapter;
import com.example.test_tab_layout1.ViewAccountList.AccountInfo;
import com.example.test_tab_layout1.ViewCompanyList.CompanyAdapter;
import com.example.test_tab_layout1.update_recInfoActivity;
import com.google.android.material.tabs.TabLayout;

import java.sql.ResultSet;
import java.sql.Statement;
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

    Spinner sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_baidang,container,false);

        recyclerView = root.findViewById(R.id.RC_congviec);
        TabLayout tl = root.findViewById(R.id.tabs);
        accountAdapter = new AccountAdapter(accountInfoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(accountAdapter);
        loaddata();

        sp = root.findViewById(R.id.sp1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nguoiDung, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sp.setAdapter(adapter);

        return root;
    }
    private void loaddata(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Nguoi_dung");
            while(rs.next()){
                accountInfoList.add(new AccountInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        }catch(Exception e){

        }
        accountAdapter.notifyDataSetChanged();
    }
}
