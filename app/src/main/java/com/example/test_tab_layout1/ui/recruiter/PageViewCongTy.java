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
import com.example.test_tab_layout1.ViewCompanyList.CompanyAdapter;
import com.example.test_tab_layout1.ViewCompanyList.CompanyInfo;
import com.example.test_tab_layout1.ViewJobList.RecJobAdapter;
import com.example.test_tab_layout1.update_congtyActivity;
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
public class PageViewCongTy extends Fragment {
    private CompanyAdapter CompanyAdapter;
    private RecyclerView recyclerView;
    Spinner sp ;
    public PageViewCongTy(){

    }
    List<CompanyInfo> companyInfoList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_baidang,container,false);
//        btn_update_congty = root.findViewById(R.id.btn_update_congty);
//        btn_update_congty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent(getContext(), update_congtyActivity.class);
//                //Todo: chuyen sang giao dien update_congtyActivity de thay doi thong tin cong ty
//                startActivity(it);
//            }
//        });
        recyclerView = root.findViewById(R.id.RC_congviec);
        TabLayout tl = root.findViewById(R.id.tabs);
        CompanyAdapter = new CompanyAdapter(companyInfoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(CompanyAdapter);
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

    @Override
    public void onResume() {
        super.onResume();
        companyInfoList.clear();
        loaddata();
    }

    private void loaddata(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Cong_ty");
            while(rs.next()){
                companyInfoList.add(new CompanyInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        }catch(Exception e){

        }
        CompanyAdapter.notifyDataSetChanged();


    }

}
