package com.example.aliang.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void addContact()
    {
       SQLiteDatabase db = getWritableDatabase();

       ContentValues values = new ContentValues();

       values.put("col1", "val1");

       db.insert(TABLE_CONTACTS, null, values);

       db.close();
    }

    void getAllContacts()
    {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TABLE_CONTACTS, null);

        if (cursor.moveToFirst())
        {
            int total = cursor.getCount();
            Log.d("total records: ", "" + total);

            do {


                String value = cursor.getString(0);

                Log.d("value: ", value);
            } while (cursor.moveToNext());

        }
    }
}
