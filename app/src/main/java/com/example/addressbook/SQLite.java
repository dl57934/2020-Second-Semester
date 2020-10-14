package com.example.addressbook;

import android.database.sqlite.SQLiteDatabase;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SQLite {
    private static SQLiteDatabase db;
    private SQLite(){}

    public static SQLiteDatabase getSqLite(SQLiteHelper sqLiteHelper){
         db = sqLiteHelper.getWritableDatabase();
        return db;
    }
}
