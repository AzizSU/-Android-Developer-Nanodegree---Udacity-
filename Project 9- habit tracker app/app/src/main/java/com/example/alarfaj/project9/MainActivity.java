package com.example.alarfaj.project9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private HabitDbHelper mDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new HabitDbHelper(this);
        this.insertHabit();
        Cursor cursor = this.readInfo();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void insertHabit() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_NAME, "Study");
        values.put(HabitContract.HabitEntry.COLUMN_TIME, "5:30PM");
        values.put(HabitContract.HabitEntry.COLUMN_DAILY, HabitContract.HabitEntry.DAILY);
        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    private Cursor readInfo() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_NAME,
                HabitContract.HabitEntry.COLUMN_TIME,
                HabitContract.HabitEntry.COLUMN_DAILY};
        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }
}
