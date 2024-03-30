package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapterUser extends ArrayAdapter {
    Context context;
    int resource;
    List<User> data;
    public CustomAdapterUser(@NonNull Context context, int resource, List<User> data) {
        super(context, resource, data);
        this.context= context;
        this.resource = resource;
        this.data = data;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvLogin = convertView.findViewById(R.id.tvLogin);
        TextView tvUrl  = convertView.findViewById(R.id.tvUrl);
        User user= data.get(position);
        tvLogin.setText(user.getLogin());
        tvUrl.setText(user.getUrl());

        Picasso.get().load(user.getAvatar_url()).into(ivHinh);



        return convertView;
    }
}
