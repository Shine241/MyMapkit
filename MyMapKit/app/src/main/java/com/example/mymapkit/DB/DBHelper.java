package com.example.mymapkit.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    // версия бд
    public static final int DATABASE_VERSION = 32;
    // название бд
    public static final String DATABASE_NAME = "DB_Point.db";
    /////////////////////////////////////////////////////////////////
    // название табицы и полей
    public static final String TABLE_MUSEUMS = "T_Museums";

    public static final String Mus_ID = "Mus_id";
    public static final String Museum_NAME = "Museum_Name";
    public static final String Museum_INFO = "Museum_Info";
    public static final String Museum_ADDRESS = "Museum_Address";
    public static final String Museum_LATITUDE = "Museum_Latitude";
    public static final String Museum_LONGITUDE = "Museum_Longitude";
    public static final String Museum_IMG_SOURCE = "Museum_Img_source";
    /////////////////////////////////////////////////////////////////
    // название табицы и полей
    public static final String TABLE_RESTAURANTS_BARS = "T_Restaurants_Bars";

    public static final String Restaurant_ID = "Restaurant_id";
    public static final String Restaurant_NAME = "Restaurant_Name";
    public static final String Restaurant_INFO = "Restaurant_Info";
    public static final String Restaurant_ADDRESS = "Restaurant_Address";
    public static final String Restaurant_LATITUDE = "Restaurant_Latitude";
    public static final String Restaurant_LONGITUDE = "Restaurant_Longitude";
    public static final String Restaurant_IMG_SOURCE = "Restaurant_Img_source";
    /////////////////////////////////////////////////////////////////
    // название табицы и полей
    public static final String TABLE_CULTURAL_CENTERS = "T_Cultural_Centers";

    public static final String Cultural_ID = "Cultural_id";
    public static final String Cultural_NAME = "Cultural_Name";
    public static final String Cultural_INFO = "Cultural_Info";
    public static final String Cultural_ADDRESS = "Cultural_Address";
    public static final String Cultural_LATITUDE = "Cultural_Latitude";
    public static final String Cultural_LONGITUDE = "Cultural_Longitude";
    public static final String Cultural_IMG_SOURCE = "Cultural_Img_source";
    /////////////////////////////////////////////////////////////////

    public static final String TABLE_MUSEUMS_STRUCTURE = "CREATE TABLE IF NOT EXISTS " + TABLE_MUSEUMS +
            " (" + Mus_ID + " INTEGER PRIMARY KEY," + Museum_NAME + " TEXT," + Museum_INFO + " TEXT," + Museum_ADDRESS + " TEXT," +
            Museum_LATITUDE + " TEXT," + Museum_LONGITUDE + " TEXT," + Museum_IMG_SOURCE + " TEXT)" ;

    public static final String TABLE_MUSEUMS_DROP = "DROP TABLE IF EXISTS " + TABLE_MUSEUMS;
////////////////////////////////////////////////////////

    public static final String TABLE_RESTAURANTS_BARS_STRUCTURE = "CREATE TABLE IF NOT EXISTS " + TABLE_RESTAURANTS_BARS +
            " (" + Restaurant_ID + " INTEGER PRIMARY KEY," + Restaurant_NAME + " TEXT," + Restaurant_INFO + " TEXT," + Restaurant_ADDRESS + " TEXT," +
            Restaurant_LATITUDE + " TEXT," + Restaurant_LONGITUDE + " TEXT," + Restaurant_IMG_SOURCE + " TEXT)" ;

    public static final String TABLE_RESTAURANTS_BARS_DROP = "DROP TABLE IF EXISTS " + TABLE_RESTAURANTS_BARS;
///////////////////////////////////////////////////////

    public static final String TABLE_CULTURAL_CENTERS_STRUCTURE = "CREATE TABLE IF NOT EXISTS " + TABLE_CULTURAL_CENTERS +
            " (" + Cultural_ID + " INTEGER PRIMARY KEY," + Cultural_NAME + " TEXT," + Cultural_INFO + " TEXT," + Cultural_ADDRESS + " TEXT," +
            Cultural_LATITUDE + " TEXT," + Cultural_LONGITUDE + " TEXT," + Cultural_IMG_SOURCE + " TEXT)" ;

    public static final String TABLE_CULTURAL_CENTERS_DROP = "DROP TABLE IF EXISTS " + TABLE_CULTURAL_CENTERS;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_MUSEUMS_STRUCTURE);
        db.execSQL(TABLE_RESTAURANTS_BARS_STRUCTURE);
        db.execSQL(TABLE_CULTURAL_CENTERS_STRUCTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_MUSEUMS_DROP);
        db.execSQL(TABLE_RESTAURANTS_BARS_DROP);
        db.execSQL(TABLE_CULTURAL_CENTERS_DROP);
        onCreate(db);
    }
}
