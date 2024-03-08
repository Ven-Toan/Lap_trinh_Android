package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity_Bai5 extends AppCompatActivity {

    EditText edtHoTen,edtCCCD;

    RadioButton radioDaiHoc, radioCaoDang, radioTrungCap;

    CheckBox cbChoiGame, cbDocSach, cbDocBao;

    Button btnDangKy, btnNhapLai, btnThoat;

    TextView textThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai5);
        setConTrol();
        setEvent();
    }

    private void setEvent(){
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="\nThông tin: ";
                msg += "\nHọ tên: " +edtHoTen.getText().toString();
                msg += "\nCCCD: " +edtCCCD.getText().toString();

                if(radioDaiHoc.isChecked()){
                    msg += "\nBằng cấp: " +radioDaiHoc.getText().toString();
                } else if (radioCaoDang.isChecked()) {
                    msg += "\nBằng cấp: " +radioCaoDang.getText().toString();
                } else {
                    msg += "\nBằng cấp: " +radioTrungCap.getText().toString();
                }
                msg+="\nSở thích: ";
                if(cbChoiGame.isChecked()){
                    msg += cbChoiGame.getText().toString();
                }
                if(cbDocSach.isChecked()){
                    msg += cbDocSach.getText().toString();
                }
                if(cbDocBao.isChecked()){
                    msg += cbDocBao.getText().toString();
                }

                textThongTin.setText(textThongTin.getText()+"\n"+msg);
                textThongTin.setTextSize(25);
                textThongTin.setBackgroundColor(Color.GREEN);

            }

        });

        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHoTen.setText("");
                edtCCCD.setText("");
                radioDaiHoc.setChecked(true);
                cbChoiGame.setChecked(false);
                cbDocSach.setChecked(false);
                cbChoiGame.setChecked(false);;
                cbDocBao.setChecked(false);
                textThongTin.setText("");
                edtHoTen.requestFocus();

            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setConTrol(){
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        radioDaiHoc = findViewById(R.id.radioDaiHoc);
        radioCaoDang = findViewById(R.id.radioCaoDang);
        radioTrungCap = findViewById(R.id.radioTrungCap);
        cbChoiGame = findViewById(R.id.cbGame);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocBao = findViewById(R.id.cbDocBao);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnNhapLai= findViewById(R.id.btnNhapLai);
        btnThoat = findViewById(R.id.btnThoat);
        textThongTin=findViewById(R.id.textThongTin);

    }
}