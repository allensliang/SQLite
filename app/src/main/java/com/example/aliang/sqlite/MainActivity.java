package com.example.aliang.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private  static final String SQL_CREATE_ENTRIES = "CREATE TABLE ";

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);

        db.addContact();
    }

    public void onButtonClicked(View view)
    {
        Log.d("Insert: ", "Inserting...");

        Log.d("db name: ", db.getDatabaseName());

        db.getAllContacts();
    }
}
