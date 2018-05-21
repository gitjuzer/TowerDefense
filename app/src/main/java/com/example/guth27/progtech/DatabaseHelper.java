package com.example.guth27.progtech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import TowerDefenseProject.Game;

public class DatabaseHelper extends SQLiteOpenHelper
{

    private  static  final  String TAG = "DataBaseHelper";
    private static  final  String TABLE_NAME = "gamedata";
    private  static  final String COL1 = "ID";
    private  static  final  String COL2 = "score";
    private  static  final  String COL3 = "time";

    public DatabaseHelper(Context context)
    {
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable  = "CREATE TABLE " + TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT," + COL3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public  boolean addData( String score, String time)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,score);
        contentValues.put(COL3,time);

        Log.d(TAG,"addData: Adding " +score+" "+time+"to"+TABLE_NAME);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return result == -1;
    }

    public Cursor getData()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = database.rawQuery(query,null);
        return  data;
    }

}