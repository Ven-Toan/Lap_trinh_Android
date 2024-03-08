package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Bai4 extends AppCompatActivity {

    EditText edtSo1,edtSo2, edtKetQua;

    Button btnCong, btnTru, btnNhan, btnChia;

    TextView textThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4);
        setControl();
    }

    public void PhepTinh(View v){
        String msg  ="";
        int so1 = Integer.parseInt(edtSo1.getText().toString());
        int so2 = Integer.parseInt(edtSo2.getText().toString());
        int ketQua = Integer.parseInt(edtKetQua.getText().toString());
        if(v.getId()==R.id.btnCong)
        {
            Toast.makeText(this,"Phép cộng", Toast.LENGTH_LONG).show();
            if(so1+so2==ketQua){
                msg=so1+" + "+so2+"="+ketQua+": Đúng";
            } else {
                msg=so1+" + "+so2+"="+ketQua+": Sai";
            }
        }
        if(v.getId()==R.id.btnTru)
        {
            Toast.makeText(this,"Phép trừ", Toast.LENGTH_LONG).show();
            if(so1-so2==ketQua){
                msg=so1+" - "+so2+"="+ketQua+": Đúng";
            } else {
                msg=so1+" - "+so2+"="+ketQua+": Sai";
            }
        }
        if(v.getId()==R.id.btnNhan)
        {
            Toast.makeText(this,"Phép nhân", Toast.LENGTH_LONG).show();
            if(so1*so2==ketQua){
                msg=so1+" x "+so2+"="+ketQua+": Đúng";
            } else {
                msg=so1+" x "+so2+"="+ketQua+": Sai";
            }
        }
        if(v.getId()==R.id.btnChia)
        {
            Toast.makeText(this,"Phép chia", Toast.LENGTH_LONG).show();
            if(so1/so2==ketQua){
                msg=so1+" / "+so2+"="+ketQua+": Đúng";
            } else {
                msg=so1+" / "+so2+"="+ketQua+": Sai";
            }
        }
        textThongTin.setText(textThongTin.getText()+"\n"+msg);
        textThongTin.setTextSize(25);
        textThongTin.setBackgroundColor(Color.GREEN);
    }

    private void setControl(){
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        edtKetQua = findViewById(R.id.edtKetQua);
        textThongTin = findViewById(R.id.textThongTin);
    }


}