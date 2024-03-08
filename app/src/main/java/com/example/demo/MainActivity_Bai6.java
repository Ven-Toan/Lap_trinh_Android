package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity_Bai6 extends AppCompatActivity {

    Switch swBongDen;

    LinearLayout llBongDen;

    ImageView ivHinh;

    ToggleButton tgbBongDen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai6);
        setControl();
        setEvent();
    }

    private void setEvent(){
        swBongDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swBongDen.isChecked()){
                    llBongDen.setVisibility(View.VISIBLE);
                }
                else {
                    llBongDen.setVisibility(View.GONE);
                    ivHinh.setImageResource(R.drawable.tat);
                    tgbBongDen.setChecked(false);
                }
            }
        });
        tgbBongDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgbBongDen.isChecked()){
                    ivHinh.setImageResource(R.drawable.bat);
                }
                else {
                    ivHinh.setImageResource(R.drawable.tat);
                }

            }
        });
    }

    private void setControl(){
        swBongDen = findViewById(R.id.swBongDen);
        llBongDen = findViewById(R.id.llBongDen);
        ivHinh = findViewById(R.id.ivHinh);
        tgbBongDen = findViewById(R.id.tgbBongDen);
    }
}