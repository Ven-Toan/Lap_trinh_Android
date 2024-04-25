package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Bai9 extends AppCompatActivity {

    ListView lvDanhSach;

    CustomAdapterUser adapterUser;

    List<User> data = new ArrayList<>();
    List<User> data_all = new ArrayList<>();

    SearchView svDanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai9);
        setControl();
        setEvent();
    }

    private void setEvent() {
        adapterUser = new CustomAdapterUser(this,R.layout.  layout_item_user,data);
        lvDanhSach.setAdapter(adapterUser);
        getData();
        //getData2();
        svDanhSach.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                data.clear();
                if(newText.equals("")){
                    data.addAll(data_all);
                }
                else {
                    for(User item: data_all){
                        if(item.getLogin().contains(newText)){
                            data.add(item);
                        }

                    }                }
                adapterUser.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void getData2() {
        String url ="https://api.github.com/search/users?q=mojombo" ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        data.clear();
                        try {
                            String total_count = jsonObject.getString("total_count");
                            Toast.makeText(MainActivity_Bai9.this,total_count,Toast.LENGTH_SHORT).show();
                            JSONArray jsonArray = jsonObject.getJSONArray("items");
                            for(int i = 0; i < jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);
                                    User user = new User();
                                    user.setLogin(object.getString("login"));
                                    user.setUrl(object.getString("url"));
                                    user.setAvatar_url(object.getString("avatar_url"));
                                    data.add(user);

                            }
                            adapterUser.notifyDataSetChanged();
                        } catch (JSONException e){
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

    private void getData(){
        String url ="https://api.github.com/users" ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for(int i = 0; i < jsonArray.length(); i++){
                            try {
                                JSONObject object = jsonArray.getJSONObject(i);
                                User user = new User();
                                user.setLogin(object.getString("login"));
                                user.setUrl(object.getString("url"));
                                user.setAvatar_url(object.getString("avatar_url"));
                                data.add(user);
                                data_all.add(user);


                            } catch (JSONException e){
                                throw new RuntimeException();
                            }
                        }
                        adapterUser.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("abc",volleyError.toString());
                    }
                });
        requestQueue.add(request);
    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        svDanhSach = findViewById(R.id.svDanhSach);
    }
}