package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    private EditText phoneEditText, ageEditText, nameEditText;
    private Button button;
    ContentValues values = new ContentValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();

        phoneEditText = findViewById(R.id.phone);
        ageEditText = findViewById(R.id.age);
        nameEditText = findViewById(R.id.name);
        button = findViewById(R.id.submitButton);
        phoneEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        button.setOnClickListener(v -> {
            setContentValue();
            db.insert(SQLiteHelper.TABLE_NAME, null, values);
            Intent inputIntent = new Intent(getApplicationContext(), MainActivity.class);
            inputIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(inputIntent);
        });
    }

    void setContentValue(){
        values.put(SQLiteHelper.COL_1, String.valueOf(nameEditText.getText()));
        values.put(SQLiteHelper.COL_2, String.valueOf(phoneEditText.getText()));
        values.put(SQLiteHelper.COL_3, Integer.parseInt(ageEditText.getText().toString()));
    }




}