package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("sanpham");
                myRef.child(sp.getMaSP()).removeValue();
                Toast.makeText(MainChiTietSanPham.this,"Xoá thành công!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setGiaSP(edtGiaSP.getText().toString());
                databaseSanPham.SuaDL(sp);
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("sanpham");
                myRef.child(sp.getMaSP()).setValue(sp);
                Toast.makeText(MainChiTietSanPham.this,"Sửa thành công!",Toast.LENGTH_SHORT).show();
                finish();
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