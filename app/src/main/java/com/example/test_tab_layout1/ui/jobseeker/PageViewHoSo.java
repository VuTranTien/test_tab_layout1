package com.example.test_tab_layout1.ui.jobseeker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
import com.example.test_tab_layout1.ViewHocVanList.HocVanAdapter;
import com.example.test_tab_layout1.ViewHocVanList.HocVanInfo;
import com.google.android.material.tabs.TabLayout;

import java.sql.ResultSet;
import java.sql.Statement;
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

    Spinner sp;

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
        hocVanInfoList.clear();
        loaddata();
    }

    private void loaddata(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Hoc_van");
            while(rs.next()){
                hocVanInfoList.add(new HocVanInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        }catch(Exception e){

        }
        hocVanAdapter.notifyDataSetChanged();

    }
}
