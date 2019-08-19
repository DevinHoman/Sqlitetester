package com.example.sqlitetester;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqlitetester.DatabaseContract.tableRules;

public class TestOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "testdatabase.db";
    private static final int DATABASE_VERSION = 1;

    //SQL create tables

    private static final String CREATE_TABLE =
            "CREATE TABLE " + tableRules.TABLE_NAME + " (" + tableRules._ID +
            " INTEGER PRIMARY KEY," + tableRules.COLUMN_NAME_TITLE + " TEXT," + tableRules.COLUMN_NAME_TEXT +
            " TEXT)";

    private static final String DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + tableRules.TABLE_NAME;
    public TestOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(tableRules.COLUMN_NAME_TITLE, "Test title");
            values.put(tableRules.COLUMN_NAME_TEXT, "test text test text");
            long rowID = db.insert(tableRules.TABLE_NAME, null, values);
        } catch (Exception e){
            Log.d("SQLite",e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DELETE_ENTRIES);
        onCreate(db);
    }


}
