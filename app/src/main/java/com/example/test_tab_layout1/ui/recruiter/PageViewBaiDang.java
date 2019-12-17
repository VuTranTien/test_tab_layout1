package com.example.test_tab_layout1.ui.recruiter;

import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
import com.example.test_tab_layout1.ViewJobList.JobAdapter;
import com.example.test_tab_layout1.ViewJobList.RecJobAdapter;
import com.example.test_tab_layout1.ViewJobList.jobInfo;
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
public class PageViewBaiDang extends Fragment {
    public PageViewBaiDang (){

    }
    private List<jobInfo> jobInfoList = new ArrayList<>();
    RecyclerView recyclerView;

    Spinner sp;

    private RecJobAdapter jobAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_baidang,container,false);

        TabLayout tl = root.findViewById(R.id.tabs);

        recyclerView = root.findViewById(R.id.RC_congviec);
        jobAdapter = new RecJobAdapter(jobInfoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobAdapter);
        loaddata();

        sp = root.findViewById(R.id.sp1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.congViec, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sp.setAdapter(adapter);

        EditText edt = root.findViewById(R.id.edtTimKiem);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }

    void loaddata(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Cong_viec");
            while(rs.next()){
                jobInfoList.add(new jobInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(12)));
            }
        }catch(Exception e){

        }
        jobAdapter.notifyDataSetChanged();


    }
}
