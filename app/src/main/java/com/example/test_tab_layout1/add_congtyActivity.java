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

public class add_congtyActivity extends AppCompatActivity {

    EditText edtTen, edtWeb, edtEmail, edtSDT, edtDiaChi, edtMoTa;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_congty);

        map();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strTen = edtTen.getText().toString();
                String strWeb = edtWeb.getText().toString();
                String strSDT = edtSDT.getText().toString();
                String strMoTa = edtMoTa.getText().toString();
                String strDiaChi = edtDiaChi.getText().toString();
                String strEmail = edtEmail.getText().toString();

                if(strWeb.length() * strMoTa.length() * strTen.length() * strDiaChi.length() * strSDT.length() * strEmail.length() == 0 ){
                    Toast.makeText(add_congtyActivity.this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                    ResultSet rs = state.executeQuery("select count(*) from Cong_ty");
                    rs.next();
                    String maso = rs.getString(1);

                    maso = String.format("%04d", Integer.parseInt(maso) + 1);

                    state.executeQuery("insert into Cong_ty values (" +
                            "'" + maso + "'," +
                            "'" + strTen +"'," +
                            "'" + strSDT +"'," +
                            "'" + strWeb +"'," +
                            "'" + strDiaChi +"'," +
                            "'" + strEmail +"'," +
                            "'" + strMoTa +"'" +
                            ")");
                }catch(Exception e){

                }

                onBackPressed();

            }
        });

    }

    void map(){
        edtTen = findViewById(R.id.edtInTenCty);
        edtWeb = findViewById(R.id.edtInWeb);
        edtEmail = findViewById(R.id.edtInEmail);
        edtSDT = findViewById(R.id.edtInSDTCty);
        edtDiaChi = findViewById(R.id.edtInDiaChiCty);
        edtMoTa = findViewById(R.id.edtInMoTaCty);

        btnOk = findViewById(R.id.btnInCty);
    }

}
