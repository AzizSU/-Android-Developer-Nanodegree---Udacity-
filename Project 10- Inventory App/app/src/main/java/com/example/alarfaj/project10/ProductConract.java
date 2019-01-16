package com.example.alarfaj.project10;

import android.provider.BaseColumns;

/**
 * Created by Alarfaj on 10/13/17.
 */

public class ProductConract {


public static final class ProductEntry implements BaseColumns {

    public static final String TABLE_NAME = "stock";

    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_SUPPLIER = "supplier";
    public static final String COLUMN_IMAGE = "image";



    public static final String CREATE_TABLE_PRODUCT = "CREATE TABLE " +
            ProductConract.ProductEntry.TABLE_NAME + "(" +
            ProductConract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ProductConract.ProductEntry.COLUMN_NAME + " TEXT NOT NULL," +
            ProductConract.ProductEntry.COLUMN_PRICE + " TEXT NOT NULL," +
            ProductConract.ProductEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
            ProductConract.ProductEntry.COLUMN_SUPPLIER + " TEXT NOT NULL," +
            ProductConract.ProductEntry.COLUMN_IMAGE + "  TEXT NOT NULL" +");";
    }
}
