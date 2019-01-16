package com.example.alarfaj.project10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alarfaj on 10/13/17.
 */

public class ProductDBHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "inventory.db";
    public final static int DB_VERSION = 1;

    public ProductDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProductConract.ProductEntry.CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //no need
    }


    public void insertItem(Product item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductConract.ProductEntry.COLUMN_NAME, item.getname());
        values.put(ProductConract.ProductEntry.COLUMN_PRICE, item.getprice());
        values.put(ProductConract.ProductEntry.COLUMN_QUANTITY, item.getQuantity());
        values.put(ProductConract.ProductEntry.COLUMN_SUPPLIER, item.getsupplier());
        values.put(ProductConract.ProductEntry.COLUMN_IMAGE, item.getImage());
        db.insert(ProductConract.ProductEntry.TABLE_NAME, null, values);
    }


    public Cursor readDB() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                ProductConract.ProductEntry._ID,
                ProductConract.ProductEntry.COLUMN_NAME,
                ProductConract.ProductEntry.COLUMN_PRICE,
                ProductConract.ProductEntry.COLUMN_QUANTITY,
                ProductConract.ProductEntry.COLUMN_SUPPLIER,
                ProductConract.ProductEntry.COLUMN_IMAGE,
        };

        Cursor cursor = db.query(
                ProductConract.ProductEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor readProduct(long current) {
        String currentString = ""+ current;
                SQLiteDatabase db = getReadableDatabase();
                String[] projection = {
                ProductConract.ProductEntry._ID,
                ProductConract.ProductEntry.COLUMN_NAME,
                ProductConract.ProductEntry.COLUMN_PRICE,
                ProductConract.ProductEntry.COLUMN_QUANTITY,
                ProductConract.ProductEntry.COLUMN_SUPPLIER,
                        ProductConract.ProductEntry.COLUMN_IMAGE,


                };
        String selection = ProductConract.ProductEntry._ID + "=?";
        String[] selectionArgs = new String[]{currentString};
        Cursor cursor = db.query(
                ProductConract.ProductEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    public void updateItem(long current, int quantity) {
        String currentString = ""+ current;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductConract.ProductEntry.COLUMN_QUANTITY, quantity);
        String selection = ProductConract.ProductEntry._ID + "=?";
        String[] selectionArgs = new String[] {currentString};
        db.update(ProductConract.ProductEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

    public void sell(long current, int quantity) {
        String currentString = ""+ current;
        SQLiteDatabase db = getWritableDatabase();
        if (quantity > 0) {
            quantity = quantity -1;
            ContentValues values = new ContentValues();
            values.put(ProductConract.ProductEntry.COLUMN_QUANTITY, quantity);
            String selection = ProductConract.ProductEntry._ID + "=?";
            String[] selectionArgs = new String[]{currentString};
            db.update(ProductConract.ProductEntry.TABLE_NAME,
                    values, selection, selectionArgs);
        }
    }
}
