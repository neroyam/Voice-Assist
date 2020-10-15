package com.example.voiceassistent.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "messageDb";
    public static final String TABLE_MESSAGES = "messages";

    public static final String FIELD_ID = "id";
    public static final String FIELD_MESSAGE = "message";
    public static final String FIELD_SEND = "send";
    public static final String FIELD_DATE = "date";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_MESSAGES + "(" +
                FIELD_ID + " integer primary key," +
                FIELD_MESSAGE + " text," +
                FIELD_SEND + " integer," +
                FIELD_DATE + " text" + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_MESSAGES);
        onCreate(db);
    }
}
