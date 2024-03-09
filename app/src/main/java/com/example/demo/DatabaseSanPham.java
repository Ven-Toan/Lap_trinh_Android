package com.example.demo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSanPham extends SQLiteOpenHelper {

    public DatabaseSanPham(@Nullable Context context) {
        super(context, "dbSanPham", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create Table tbSanPham (masp text,tensp text, giasp text, loaisp text)";
        db.execSQL(sql);
    }

    public void ThemDL(SanPham sp){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "Insert Into tbSanPham Values (?,?,?,?)";
        database.execSQL(sql,new String[]{sp.getMaSP(),sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSP()});
    }

    public void XoaDL(SanPham sp){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "Delete from tbSanPham Where masp=?";
        database.execSQL(sql, new String[]{sp.getMaSP()});
    }

    public void SuaDL(SanPham sp){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "Update tbSanPham set tensp=?, giasp=?, loaisp=? where masp=?";
        database.execSQL(sql,new String[]{sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSP(),sp.getMaSP()});
    }

    public List<SanPham> DocDl(){
        SQLiteDatabase database = getReadableDatabase();
        List<SanPham> data = new ArrayList<>();
        String sql = "Select * from tbSanPham";
        Cursor cursor = database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setGiaSP(cursor.getString(2));
                sp.setLoaiSP(cursor.getString(3));
                data.add(sp);
            }while ( cursor.moveToNext());
        }
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
