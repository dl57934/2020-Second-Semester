package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
    ListView listview;
    ArrayList<UserInfo> userInfos;
    String[] columns = {
            SQLiteHelper.COL_1,
            SQLiteHelper.COL_2,
            SQLiteHelper.COL_3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectAddressInfo();
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        listview = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(this, userInfos);
        listview.setAdapter(myAdapter);

        floatingActionButton.setOnClickListener(v -> {
            Intent inputIntent = new Intent(getApplicationContext(), InputActivity.class);
            startActivity(inputIntent);
        });
    }


    void selectAddressInfo(){
        Cursor cursor = SQLite.getSqLite(sqLiteHelper).query(SQLiteHelper.TABLE_NAME, columns, null, null, null, null, null);
        userInfos = new ArrayList<UserInfo>();
        while(cursor.moveToNext()){
            userInfos.add(new UserInfo(this.getColumnStringIndexData(cursor, SQLiteHelper.COL_1), this.getColumnStringIndexData(cursor, SQLiteHelper.COL_2), this.getColumnIntIndexData(cursor, SQLiteHelper.COL_3)));
        }

        cursor.close();
    }

    String getColumnStringIndexData(Cursor cursor, String column){
        return String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(column)));
    }

    int getColumnIntIndexData(Cursor cursor, String column){
        return cursor.getInt(cursor.getColumnIndexOrThrow(column));
    }
}


class UserInfo{
    private String name, phoneNumber;
    int age;

    UserInfo(String name, String phoneNumber, int age){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}