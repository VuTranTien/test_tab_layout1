package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_tab_layout1.ViewAccountList.AccountInfo;

import java.sql.Statement;

public class add_hocvanActivity extends AppCompatActivity {

    EditText edtTen, edtMaSo, edtNam, edtChuyenNganh;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hocvan);

        map();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTen = edtTen.getText().toString();
                String strMaSo = edtMaSo.getText().toString();
                String strNam = edtNam.getText().toString();
                String strChuyenNganh = edtChuyenNganh.getText().toString();

                if(strTen.length() * strMaSo.length() * strNam.length() * strChuyenNganh.length()  == 0 ){
                    Toast.makeText(add_hocvanActivity.this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                    state.executeQuery("insert into Hoc_van values (" +
                            "'" + strTen + "'," +
                            "'" + strMaSo +"'," +
                            "'" + strNam +"'," +
                            "N'" + strChuyenNganh + "'" +
                            ")");
                }catch(Exception e){

                }

                onBackPressed();
            }
        });

    }

    void map(){
        edtTen = findViewById(R.id.insertTen);
        edtChuyenNganh = findViewById(R.id.insertChuyenNganh);
        edtMaSo = findViewById(R.id.insertMaSoCV);
        edtNam = findViewById(R.id.insertNam);

        btnOk = findViewById(R.id.btnInsertHocVan);
    }

}
