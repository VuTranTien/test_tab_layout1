package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_tab_layout1.ViewAccountList.AccountInfo;
import com.example.test_tab_layout1.ViewCompanyList.CompanyInfo;
import com.example.test_tab_layout1.ViewHocVanList.HocVanInfo;
import com.example.test_tab_layout1.ViewJobList.jobInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class dangnhapActivity extends AppCompatActivity {

    EditText edtUser,edtPass;
    Button btndangki,btndangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        anhxa();
        edtUser.setText("nhatuyendung");
        edtPass.setText("123456");
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangnhap();
            }
        });
        btndangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(dangnhapActivity.this,dangkiActivity.class);
                //Todo: dung intent de gui du lieu neu can
                 startActivity(it);
            }
        });

        loadAccount();
        loadHocVan();
        loadCongty();
        loadCongViec();
    }
    void anhxa(){
        edtUser = findViewById(R.id.edtuser);
        edtPass = findViewById(R.id.edtpass);
        btndangnhap = findViewById(R.id.btndangnhap);
        btndangki = findViewById(R.id.btndangki);
    }
    private void dangnhap(){

        if(edtUser.getText().toString().equals("nguoitimviec") && edtPass.getText().toString().equals("123456")){
            Toast.makeText(dangnhapActivity.this,"Chào mừng bạn trở lại!",Toast.LENGTH_SHORT).show();
            Intent it = new Intent(dangnhapActivity.this,MainActivity.class);
            //Todo: dung intent de gui du lieu neu can
            startActivity(it);
        }
        else if(edtUser.getText().toString().equals("nhatuyendung") && edtPass.getText().toString().equals("123456")){
            Toast.makeText(dangnhapActivity.this,"Chào mừng bạn trở lại!",Toast.LENGTH_SHORT).show();
            Intent it = new Intent(dangnhapActivity.this,recruiterActivity.class);
            //Todo: dung intent de gui du lieu neu can
            startActivity(it);
        }
        else {
            Toast.makeText(dangnhapActivity.this,"Sai username hoặc password!",Toast.LENGTH_SHORT).show();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------
    public void loadAccount(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Nguoi_dung");
            while(rs.next()){
                App.acounts.add(new AccountInfo(
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
            edtUser.setText(e.getMessage());
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------
    public void loadCongty(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Cong_ty");
            while(rs.next()){
                App.companys.add(new CompanyInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        }catch(Exception e){
            edtUser.setText(e.getMessage());
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------
    public void loadHocVan(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Hoc_van");
            while(rs.next()){
                App.hocVans.add(new HocVanInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        }catch(Exception e){
            edtUser.setText(e.getMessage());
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------
    public void loadCongViec(){
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Cong_viec");
            while(rs.next()){
                App.jobs.add(new jobInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(12)));
            }
        }catch(Exception e){
            edtUser.setText(e.getMessage());
        }
    }
}
