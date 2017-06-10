package com.example.kleocida.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.kleocida.habittrackerapp.HabitContract.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView checkDatabase = (TextView) findViewById(R.id.check_db);

        //CREATE DATABASE HELPER
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        //CREATE VALUE TO INSERT
        ContentValues values = new ContentValues();
        values.put(HabitDbEntry.DOG_WALKING, "walking with my dog");
        values.put(HabitDbEntry.WALKING_LENGTH, 1);

        habitDbHelper.insertValue(values);
        Cursor cursor = habitDbHelper.readHabit(1);
        String string = "I m " + cursor.getString(1) + " " + cursor.getInt(2) + " hour today.";
        cursor.close();
        checkDatabase.setText(string);
    }
}
