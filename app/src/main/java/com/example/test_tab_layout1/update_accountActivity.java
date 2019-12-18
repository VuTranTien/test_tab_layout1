package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_tab_layout1.ViewAccountList.AccountInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class update_accountActivity extends AppCompatActivity {

    EditText user, hoTen, ten, diaChi, sdt, email, cty;
    Button btnOk;
    AccountInfo account = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);

        final String username = getIntent().getStringExtra("username");
        Toast.makeText(this, username, Toast.LENGTH_LONG).show();
        map();

        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Nguoi_dung where Username = '" + username + "'");
            rs.next();
            account = new AccountInfo(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9));
            loadDataToView();
        }catch(Exception e){

        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = user.getText().toString();
                String strHoTen = hoTen.getText().toString();
                String strTen = ten.getText().toString();
                String strDiaChi = diaChi.getText().toString();
                String strSDT = sdt.getText().toString();
                String strEmail = email.getText().toString();
                String strCty = cty.getText().toString();

                if (strUser.length()  * strHoTen.length() * strTen.length() * strDiaChi.length() * strSDT.length() * strEmail.length() == 0) {
                    Toast.makeText(update_accountActivity.this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                    state.execute("update Nguoi_dung set " +
                            "Username = '" + strUser + "'," +
                            "Email = '" + strEmail + "'," +
                            "HoTenDem = '" + strHoTen + "'," +
                            "Ten = '" + strTen + "'," +
                            "DiaChi = '" + strDiaChi + "'," +
                            "SDT = '" + strSDT + "' where Username = '" + account.getUsername() + "'");
                } catch (Exception e) {
                    Toast.makeText(update_accountActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                onBackPressed();

            }
        });
    }

    public void map(){
        user = findViewById(R.id.edtUpUser);
        hoTen = findViewById(R.id.edtUpHoTen);
        ten = findViewById(R.id.edtUpTen);
        diaChi = findViewById(R.id.edtUpDiaChi);
        sdt = findViewById(R.id.edtUpSDT);
        email = findViewById(R.id.edtUpEmail);
        cty = findViewById(R.id.edtUpCty);

        btnOk = findViewById(R.id.btnUpOk);
    }

    void loadDataToView(){
        user.setText(account.getUsername());
        hoTen.setText(account.getHotendem());
        ten.setText(account.getTen());
        diaChi.setText(account.getDiachi());
        sdt.setText(account.getSdt());
        email.setText(account.getEmail());
        cty.setText(account.getMacongty());
    }

}
