package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Bai9 extends AppCompatActivity {

    ListView lvDanhSach;

    CustomAdapterUser adapterUser;

    List<User> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai9);
        setControl();
        setEvent();
    }

    private void setEvent() {
        adapterUser = new CustomAdapterUser(this,R.layout.layout_item_user,data);
        lvDanhSach.setAdapter(adapterUser);
        getData();
    }

    private void getData(){
        String url ="https://api.github.com/users" ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}