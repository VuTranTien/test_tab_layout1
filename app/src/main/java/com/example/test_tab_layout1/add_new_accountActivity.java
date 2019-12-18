package com.example.test_tab_layout1;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_tab_layout1.ViewAccountList.AccountInfo;
import com.example.test_tab_layout1.ViewJobList.jobInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class add_new_accountActivity extends AppCompatActivity {
    EditText user, pass, hoTen, ten, diaChi, sdt, email, cty;
    Button btnOk;
    public static AccountInfo account = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_account);
        //Todo: tai khoan tao mac dinh la nguoi tim viec
        map();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = user.getText().toString();
                String strPass = pass.getText().toString();
                String strHoTen = hoTen.getText().toString();
                String strTen = ten.getText().toString();
                String strDiaChi = diaChi.getText().toString();
                String strSDT = sdt.getText().toString();
                String strEmail = email.getText().toString();
                String strCty = cty.getText().toString();
                
                if(strUser.length() * strPass.length() * strHoTen.length() * strTen.length() * strDiaChi.length() * strSDT.length() * strEmail.length() == 0 ){
                    Toast.makeText(add_new_accountActivity.this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                account = new AccountInfo(strUser, strPass, strEmail, strHoTen, strTen, strSDT, strDiaChi, "1", strCty);

                String maso = (strCty.equals("")) ? "null" : "'" + strCty + "'";

                String at = (strCty.equals("")) ? "1" : "2";

                try {
                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                    state.executeQuery("insert into Nguoi_dung values (" +
                            "'" + account.getUsername() + "'," +
                            "'" + account.getPass() +"'," +
                            "'" + account.getEmail() +"'," +
                            "'" + account.getHotendem() +"'," +
                            "'" + account.getTen() +"'," +
                            "'" + account.getSdt() +"'," +
                            "'" + account.getDiachi() +"'," +
                            at + "," +
                            maso + 
                            ")");
                }catch(Exception e){
                    
                }

                onBackPressed();

            }
        });
        
    }
    
    void map(){
        user = findViewById(R.id.edtUser);
        pass = findViewById(R.id.edtPass);
        hoTen = findViewById(R.id.edtHoTen);
        ten = findViewById(R.id.edtTen);
        diaChi = findViewById(R.id.edtDiaChi);
        sdt = findViewById(R.id.edtSDT);
        email = findViewById(R.id.edtEmail);
        cty = findViewById(R.id.edtCongTy);
        
        btnOk = findViewById(R.id.btnOk);
    }
    
}
