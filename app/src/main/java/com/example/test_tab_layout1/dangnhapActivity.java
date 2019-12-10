package com.example.test_tab_layout1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
}
