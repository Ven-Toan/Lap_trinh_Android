package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity_Bai11 extends AppCompatActivity {

    EditText edtTaiKhoan,edtMatKhau;
    Button btnDangNhap, btnBieuDo;

    CheckBox cbGhiMatKhau;
    PieChart pieChart;

    int thanhCong = 4;
    int tongDangNhap = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai11);
        setControl();
        setEvent();
        onResume();
    }

    private void setEvent() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tongDangNhap++;
                if(edtTaiKhoan.getText().toString().equals(edtMatKhau.getText().toString())){
                    thanhCong++;
                    Toast.makeText(MainActivity_Bai11.this, "Thành công", Toast.LENGTH_SHORT).show();
                    if(cbGhiMatKhau.isChecked())
                    {
                        GhiMatKhau();
                    } else
                    {
                        XoaMatKhau();    
                    }
                }
                else
                {
                    Toast.makeText(MainActivity_Bai11.this, "Đăng nhập thất bại ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBieuDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HienBieuDo();
            }
        });
    }

    private void HienBieuDo() {
        ArrayList<PieEntry> data =  new ArrayList<>();
        data.add(new PieEntry(thanhCong));
        data.add(new PieEntry(tongDangNhap-thanhCong));
        ArrayList<Integer> data_color  = new ArrayList<>();
        data_color.add(Color.BLUE);
        data_color.add(Color.RED);
        PieDataSet pieDataSet = new PieDataSet(data, "Dang nhap");

        pieDataSet.setColors(data_color);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    private void XoaMatKhau() {
        SharedPreferences sharedPreferences = getSharedPreferences("LuuMatKhau", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private void GhiMatKhau() {
        SharedPreferences sharedPreferences = getSharedPreferences("LuuMatKhau", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", edtTaiKhoan.getText().toString());
        editor.putString("Password", edtMatKhau.getText().toString());
        editor.apply();

    }

    protected void DocGhiNho(){
        SharedPreferences sharedPreferences = getSharedPreferences("LuuMatKhau", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("Username","");
        String password = sharedPreferences.getString("Password","");
        edtTaiKhoan.setText(username);
        edtMatKhau.setText(password);
    }

    @Override
    protected void onResume(){
        super.onResume();
        DocGhiNho();
    }

    private void setControl() {
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnBieuDo = findViewById(R.id.btnBieuDo);
        cbGhiMatKhau = findViewById(R.id.cbGhiMatKhau);
        pieChart = findViewById(R.id.pieChart);

    }
}