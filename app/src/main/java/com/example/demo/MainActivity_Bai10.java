package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity_Bai10 extends AppCompatActivity {

    EditText edtThongBao;
    Button btnThongBao;
    EditText edtTenSanPham, edtGiaSanPham;
    Button btnThem;
    ListView lvDanhSach;
    List<SanPham> data;
    CustomAdapterSP adapterSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai10);

        setControl();
        setEvent();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
    }

    private void setEvent() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        DatabaseReference sanphams = database.getReference("sanpham");

        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue(edtThongBao.getText().toString());

            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String msg = snapshot.getValue(String.class);
                edtThongBao.setText(msg);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adapterSP = new CustomAdapterSP(this, R.layout.layout_item_sp,data);
        lvDanhSach.setAdapter(adapterSP);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSP(sanphams.push().getKey());
                sanPham.setTenSP(edtTenSanPham.getText().toString());
                sanPham.setGiaSP(edtTenSanPham.getText().toString());
                sanPham.setLoaiSP("SamSung");
                sanphams.child(sanPham.getMaSP()).setValue(sanPham);

            }
        });
    }

    private void setControl() {
        edtThongBao = findViewById(R.id.edtThongBao);
        btnThongBao = findViewById(R.id.btnThongBao);
        edtTenSanPham = findViewById(R.id.edtTenSanPham);
        edtGiaSanPham = findViewById(R.id.edtGiaSanPham);
        btnThem = findViewById(R.id.btnThem);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}