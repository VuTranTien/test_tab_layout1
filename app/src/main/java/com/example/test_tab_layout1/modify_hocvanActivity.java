package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_tab_layout1.ViewAccountList.AccountInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class modify_hocvanActivity extends AppCompatActivity {
    EditText edtTen, edtNam, edtChuyenNganh;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_hocvan);

        map();
        final String maSoCV = getIntent().getStringExtra("masocv");
        final String tenTruong = getIntent().getStringExtra("tentruong");
        Toast.makeText(this, maSoCV, Toast.LENGTH_SHORT).show();

        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Hoc_van where TenTruong = '" + tenTruong + "' and MaSoCV = '" + maSoCV + "'");
            rs.next();
            edtTen.setText(rs.getString(1));
            edtNam.setText(rs.getString(3));
            edtChuyenNganh.setText(rs.getString(4));
        }catch(Exception e){

        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTen = edtTen.getText().toString();
                String strNam = edtNam.getText().toString();
                String strChuyenNganh = edtChuyenNganh.getText().toString();

                if(strTen.length()  * strNam.length() * strChuyenNganh.length()  == 0 ){
                    Toast.makeText(modify_hocvanActivity.this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                    state.execute("update Hoc_van set " +
                            "TenTruong = '" + strTen + "'," +
                            "NamTotNghiep = '" + strNam + "'," +
                            "ChuyenNganh = '" + strChuyenNganh + "'" +
                            " where TenTruong = '" + tenTruong + "' and MaSoCV = '" + maSoCV + "'");
                }catch(Exception e){

                }

                onBackPressed();
            }
        });

    }

    void map(){
        edtTen = findViewById(R.id.updateTenTruong);
        edtChuyenNganh = findViewById(R.id.updateChuyenNganh);
        edtNam = findViewById(R.id.updateNamTotNghiep);

        btnOk = findViewById(R.id.btnUpdateHocVan);
    }

}
