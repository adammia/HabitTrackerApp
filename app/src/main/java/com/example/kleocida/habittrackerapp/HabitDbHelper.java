package com.example.kleocida.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.kleocida.habittrackerapp.HabitContract.*;

/**
 * Created by Kleocida on 2017. 06. 10..
 */

class HabitDbHelper extends SQLiteOpenHelper {
    //DATABASE VERSION
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    private static final String DATABASE_NAME = "habits.db";

    //DATABASE
    private SQLiteDatabase sqLiteDatabase;

    HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATE NEW TABLE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_HABIT_TRACKER_TABLE = "CREATE TABLE " + HabitDbEntry.DB_HABIT_TABLE_NAME + "(" +
                HabitDbEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HabitDbEntry.DOG_WALKING + " TEXT NOT NULL, " +
                HabitDbEntry.WALKING_LENGTH + " INT NOT NULL DEFAULT 0);";
        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TRACKER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + HabitContract.HabitDbEntry.DB_HABIT_TABLE_NAME;
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    void insertValue(ContentValues contentValues) {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(HabitDbEntry.DB_HABIT_TABLE_NAME, null, contentValues);
    }

    Cursor readHabit(int id) {
        Cursor cursor;
        String selection = HabitDbEntry.HABIT_ID + "=?";
        String[] sArgs = new String[]{Integer.toString(id)};
        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(true,
                HabitDbEntry.DB_HABIT_TABLE_NAME, null, selection, sArgs, null, null,
                null, null);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }

}
