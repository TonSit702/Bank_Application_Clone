package com.example.bcelone;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private boolean isHidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageButton bthidden = findViewById(R.id.btHidden);
        TextView textview = findViewById(R.id.txt_money);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ImageButton btstatement = findViewById(R.id.btstatement);
        btstatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Statement.class);
                startActivity(intent);


            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        bthidden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHidden){
                    textview.setText("859,000");
                }
                else {
                    textview.setText("*********");
                }
                isHidden = !isHidden;
            }
        });
        DBmain dbHelper = new DBmain(this);

        // Open the database for writing
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Example data to be inserted
        String username = "JohnDoe";
        String password = "123456";
        String title = "Transaction Title";
        String description = "Transaction Description";
        int image = R.drawable.income; // Replace with your actual image resource
        String money = "$100";
        String fromAccount = "BACKMIL JOB";

        // Create a ContentValues object to store the data
//        ContentValues values = new ContentValues();
//        values.put(DBmain.COLUMN_USERNAME, username);
//        values.put(DBmain.COLUMN_PASSWORD, password);
//        values.put(DBmain.COLUMN_TITLE, title);
//        values.put(DBmain.COLUMN_DESCRIPTION, description);
//        values.put(DBmain.COLUMN_MONEY, money);
//        values.put(DBmain.COLUMN_FROM_ACCOUNT, fromAccount);
//
//        // Insert the data into the database
//        long newRowId = db.insert(DBmain.TABLE_NAME, null, values);
//
//        // Check if the insertion was successful
//        if (newRowId != -1) {
//            Toast.makeText(this, "Data inserted successfully with row ID: " + newRowId, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Error inserting data", Toast.LENGTH_SHORT).show();
//        }

        // Close the database
        dbHelper.close();

    }
}