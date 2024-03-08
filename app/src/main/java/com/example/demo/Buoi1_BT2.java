package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Buoi1_BT2 extends AppCompatActivity {

    EditText edtTieuDe, edtNoiDung;

    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buoi1_bt2);
        setControl();
        setEvent();
    }

    private void setEvent(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="Thông tin";
                msg+="\nTiêu đề: " + edtTieuDe.getText().toString();
                msg+="\nNội dung: " + edtNoiDung.getText().toString();

                Toast.makeText(Buoi1_BT2.this, msg,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setControl(){
        edtTieuDe = findViewById(R.id.edtTieuDe);
        edtNoiDung = findViewById(R.id.edtNoiDung);
        btnSend = findViewById(R.id.btnSend);

    }
}