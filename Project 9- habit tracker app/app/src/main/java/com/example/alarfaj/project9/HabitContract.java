package com.example.alarfaj.project9;

import android.provider.BaseColumns;



public class HabitContract {

    public HabitContract() {
    }

    public class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "haptis_info";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_TIME = "time";
        public final static String COLUMN_DAILY = "daily";
        public static final int DAILY = 0;
        public static final int NOT_DAILY = 1;
    }

}
