package com.example.alarfaj.project9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HabitDbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "habitDB.db";
    private static final int DB_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_TRACKING_TABLE= "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME +
                " (" + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitContract.HabitEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                HabitContract.HabitEntry.COLUMN_TIME+ " TEXT NOT NULL, " +
                HabitContract.HabitEntry.COLUMN_DAILY + " INTEGER NOT NULL DEFAULT 1);";
        db.execSQL(CREATE_TABLE_TRACKING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
