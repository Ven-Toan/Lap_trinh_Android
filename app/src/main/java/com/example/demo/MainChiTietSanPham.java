package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainChiTietSanPham extends AppCompatActivity {

    EditText edtMaSP,edtTenSP,edtGiaSP;

    Button btnXoa, btnSua, btnQuaylai;

    DatabaseSanPham databaseSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chi_tiet_san_pham);
        setControl();
        setEvent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setEvent(){
        databaseSanPham = new DatabaseSanPham(this);
        SanPham sp = (SanPham) getIntent().getSerializableExtra("item");
        edtMaSP.setText((sp.getMaSP()));
        edtTenSP.setText((sp.getTenSP()));
        edtGiaSP.setText((sp.getGiaSP()));

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseSanPham.XoaDL(sp);
                Toast.makeText(MainChiTietSanPham.this,"Xoá thành công!",Toast.LENGTH_SHORT).show();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setGiaSP(edtGiaSP.getText().toString());
                databaseSanPham.SuaDL(sp);
                Toast.makeText(MainChiTietSanPham.this,"Sửa thành công!",Toast.LENGTH_SHORT).show();
            }
        });

        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void setControl(){
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnQuaylai = findViewById(R.id.btnQuaylai);
    }
}