package com.autotextview2.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by R Santosh on 15-06-2016.
 */
public class ProductDBHelper extends SQLiteOpenHelper {

    //Declaration Section.
    //Name of the database.
    private static final String DATABASE_NAME = "stock";
    //Version of the database.
    private static final int DATABASE_VERSION = 1;
    //Table Name.
    private static final String TABLE_NAME = "product_details";
    private static final String PRODUCT_ID = "product_id";
    private static final String PRODUCT_NAME = "product_name";
    //Database.
    SQLiteDatabase db;

    public ProductDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String strCreateTable = "create table " + TABLE_NAME + "(" + PRODUCT_ID + " integer primary key, " + PRODUCT_NAME + " text);";
        sqLiteDatabase.execSQL(strCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(String strName){

        db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(PRODUCT_NAME,strName);

        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public ArrayList<String> getData(){

        ArrayList<String> mArray;
        mArray = new ArrayList<>();

        db = getReadableDatabase();
        String strQuery = "select * from " + TABLE_NAME;

        Cursor cursor = db.rawQuery(strQuery,null);

        if(cursor.moveToFirst())

            do {

                mArray.add(cursor.getString(1));

            }while(cursor.moveToNext());

        db.close();
        return mArray;

    }

}
