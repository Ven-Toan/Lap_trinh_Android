package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Bai2 extends AppCompatActivity {

    EditText edtTaiKhoan,edtMatKhau,edtSdt,edtEmail;

    Button btnDangKy, btnNhapLai;

    TextView textThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai2);
        setControl();
        setEvent();
    }

    private void setEvent(){
        btnDangKy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (edtTaiKhoan.getText().toString().equals("")){
                    edtTaiKhoan.setError("Không được để trống!");
                    edtTaiKhoan.requestFocus();
                    Toast.makeText(MainActivity_Bai2.this, "Hãy nhập tài khoản",Toast.LENGTH_LONG).show();
                    return ;

                }
                String msg = "Thông tin tài khoản";
                msg += "\nTài khoản: " + edtTaiKhoan.getText().toString();
                msg += "\nMật khẩu: " + edtMatKhau.getText().toString();
                msg += "\nSố điện thoại: " + edtSdt.getText().toString();
                msg += "\nEmail: " + edtEmail.getText().toString();
                textThongTin.setText(msg);



            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                edtTaiKhoan.setText("");
                edtMatKhau.setText("");
                edtSdt.setText("");
                edtEmail.setText("");
                textThongTin.setText("");
            }
        });

    }

    private void setControl(){
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtSdt = findViewById(R.id.edtSdt);
        edtEmail = findViewById(R.id.edtEmail);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnNhapLai = findViewById(R.id.btnNhapLai);
        textThongTin = findViewById(R.id.textThongTin);
    }

}