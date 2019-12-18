package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

public class modify_congtyActivity extends AppCompatActivity {

    EditText edtTen, edtWeb, edtEmail, edtSDT, edtDiaChi, edtMoTa;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_congty);

        map();

        final String maSoCty = getIntent().getStringExtra("macongty");

        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rs = state.executeQuery("select * from Cong_ty where MaSoCty = '" + maSoCty + "'");
            rs.next();

            edtTen.setText(rs.getString(2));
            edtSDT.setText(rs.getString(3));
            edtWeb.setText(rs.getString(4));
            edtDiaChi.setText(rs.getString(5));
            edtEmail.setText(rs.getString(6));
            edtMoTa.setText(rs.getString(7));

        }catch(Exception e){

        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTen = edtTen.getText().toString();
                String strSDT = edtSDT.getText().toString();
                String strWeb = edtWeb.getText().toString();
                String strDiaChi = edtDiaChi.getText().toString();
                String strEmail = edtEmail.getText().toString();
                String strMoTa = edtMoTa.getText().toString();

                if (strTen.length()  * strMoTa.length() * strWeb.length() * strDiaChi.length() * strSDT.length() * strEmail.length() == 0) {
                    Toast.makeText(modify_congtyActivity.this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                    state.execute("update Cong_ty set " +
                            "TenCty = '" + strTen + "'," +
                            "SDT = '" + strSDT + "'," +
                            "Website = '" + strWeb + "'," +
                            "DiaChi = '" + strDiaChi + "'," +
                            "Email = '" + strEmail + "', " +
                            "MoTaCty = '" + strMoTa + "'" +
                            " where MaSoCty = '" + maSoCty + "'");
                }catch(Exception e){

                }

                onBackPressed();
            }
        });

    }

    void map(){
        edtTen = findViewById(R.id.edtUpdateTenCty);
        edtWeb = findViewById(R.id.edtUpdateWebsiteCty);
        edtEmail = findViewById(R.id.edtUpdateEmailCty);
        edtSDT = findViewById(R.id.edtUpdateSDTCty);
        edtDiaChi = findViewById(R.id.edtUpdateDiaChiCty);
        edtMoTa = findViewById(R.id.edtUpdateMoTaCty);

        btnOk = findViewById(R.id.btnUpdateCty);
    }

}
