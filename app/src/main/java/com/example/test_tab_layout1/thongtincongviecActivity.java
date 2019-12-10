package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class thongtincongviecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtincongviec);
        anhxa();
        Intent it = getIntent();
        String st = it.getStringExtra("mabaidang");
        txt_tenvieclam.setText(st);


    }
    TextView txt_thongtincongty;
    TextView txt_tenvieclam;
    TextView txt_thoihantuyen;
    TextView txt_luong;
    TextView txt_chucvu;
    TextView txt_gioitinh;
    TextView txt_kinhnghiem ;
    TextView txt_diadiemlamviec ;
    TextView txt_motacongviec  ;
    TextView txt_yeucaucongviec ;
    TextView txt_quyenloi;
    void anhxa(){
//        tl = root.findViewById(R.id.tabs);
        txt_thongtincongty = findViewById(R.id.txt_thongtincongty);
        txt_tenvieclam = findViewById(R.id.txt_tencongviec);
        txt_thoihantuyen= findViewById(R.id.txt_thoihantuyen);
        txt_luong= findViewById(R.id.txt_luong);
        txt_gioitinh = findViewById(R.id.txt_gioitinh);
        txt_chucvu = findViewById(R.id.txt_chucvu);
        txt_kinhnghiem = findViewById(R.id.txt_kinhnghiem);
        txt_diadiemlamviec =findViewById(R.id.txt_diadiemlamviec);
        txt_motacongviec = findViewById(R.id.txt_motacongviec);
        txt_yeucaucongviec = findViewById(R.id.txt_yeucaucongviec);
        txt_quyenloi = findViewById(R.id.txt_quyenloi);
    }
}
