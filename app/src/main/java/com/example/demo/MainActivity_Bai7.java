package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Bai7 extends AppCompatActivity {

    EditText edtMaSP, edtTenSP, edtGiaSP;

    Spinner spLoaiSP;

    List<String> data_lsp = new ArrayList<>();

    ArrayAdapter adapter_lsp;

    ImageView ivHinh;

    Button btnThem, btnXoa, btnSua, btnThoat;

    ListView lvDanhSach;

    List<SanPham> data_sp = new ArrayList<>();

    CustomAdapterSP adapter_sp;

    int index = -1;

    DatabaseSanPham databaseSanPham = new DatabaseSanPham(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai7);
        setControl();
        setEvent();
    }

    private void setEvent(){
        databaseSanPham = new DatabaseSanPham(this);
        KhoiTao();
        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lsp);
        spLoaiSP.setAdapter(adapter_lsp);
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spLoaiSP.getSelectedItem().equals("Samsung")){
                    ivHinh.setImageResource(R.drawable.samsung);
                }
                if(spLoaiSP.getSelectedItem().equals("Iphone")){
                    ivHinh.setImageResource(R.drawable.iphone);
                }
                if(spLoaiSP.getSelectedItem().equals("Nokia")){
                    ivHinh.setImageResource(R.drawable.nokia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity_Bai7.this, "Chưa chọn sp", Toast.LENGTH_SHORT).show();
            }

        });
        adapter_sp = new CustomAdapterSP(this, R.layout.layout_item_sp, data_sp);
        lvDanhSach.setAdapter(adapter_sp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
            }
        });
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = data_sp.get(position);
                edtMaSP.setText(sp.getMaSP());
                edtTenSP.setText(sp.getTenSP());
                edtGiaSP.setText(sp.getGiaSP());
                if (sp.getLoaiSP().equals("Samsung")){
                    spLoaiSP.setSelection(0);
                }
    if (sp.getLoaiSP().equals("Iphone")){
        spLoaiSP.setSelection(1);
    }
                if (sp.getLoaiSP().equals("Nokia")){
        spLoaiSP.setSelection(2);
    }
    index = position;

}
        });
    lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            data_sp.remove(position);
            adapter_sp.notifyDataSetChanged();
            return false;
        }
    });
        btnXoa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SanPham sp = new SanPham();
            sp.setMaSP(edtMaSP.getText().toString());
            databaseSanPham.XoaDL(sp);
            DocDl();
        }
    });
        btnSua.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SanPham sp = new SanPham();
            sp.setMaSP(edtMaSP.getText().toString());
            sp.setTenSP(edtTenSP.getText().toString());
            sp.setGiaSP(edtGiaSP.getText().toString());
            sp.setLoaiSP(spLoaiSP.getSelectedItem().toString());
            databaseSanPham.SuaDL(sp);
            DocDl();
        }
    });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
}

    private void ThemDL(){
        SanPham sp =  new SanPham();
        sp.setMaSP(edtMaSP.getText().toString());
        sp.setTenSP(edtTenSP.getText().toString());
        sp.setGiaSP(edtGiaSP.getText().toString());
        sp.setLoaiSP(spLoaiSP.getSelectedItem().toString());
        databaseSanPham.ThemDL(sp);
        DocDl();
    }

    public void DocDl(){
        data_sp.clear();
        data_sp.addAll(databaseSanPham.DocDl());
        adapter_sp.notifyDataSetChanged();
    }


    private void KhoiTao(){
        data_lsp.add("Samsung");
        data_lsp.add("Iphone");
        data_lsp.add("Nokia");
    }

    private void setControl(){
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}