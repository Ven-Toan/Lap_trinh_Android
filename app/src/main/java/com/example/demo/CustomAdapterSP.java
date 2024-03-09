package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapterSP extends ArrayAdapter {
    Context context;

    int resource;

    List<SanPham> data;
    public CustomAdapterSP(@NonNull Context context, int resource, @NonNull List<SanPham> data){
        super(context,resource,data);
        this.context=context;
        this.data = data;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent){
        converView = LayoutInflater.from(context).inflate(resource,null);
        ImageView ivHinh = converView.findViewById(R.id.ivHinh);
        TextView tvTenSP = converView.findViewById(R.id.tvTenSP);
        Button btnCHiTiet = converView.findViewById(R.id.btnChiTiet);
        SanPham sp = data.get(position);
        tvTenSP.setText(sp.getTenSP());
        if(sp.getLoaiSP().equals("Samsung")){
            ivHinh.setImageResource(R.drawable.samsung);
        }
        if(sp.getLoaiSP().equals("Iphone")){
            ivHinh.setImageResource(R.drawable.iphone);
        }
        if(sp.getLoaiSP().equals("Nokia")){
            ivHinh.setImageResource(R.drawable.nokia);
        }
        btnCHiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainChiTietSanPham.class);
                intent.putExtra("item",sp);
                context.startActivity(intent);
            }
        });
        return converView;
    }
}
