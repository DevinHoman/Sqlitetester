package com.example.sqlitetester;

import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract(){}

    public static class tableRules implements BaseColumns {
        public static final String TABLE_NAME = "test_table";
        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_NAME_TEXT = "text";

    }
}
