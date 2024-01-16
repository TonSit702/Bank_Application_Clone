package com.example.bcelone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private DBmain dbHelper; // Declare dbHelper as a class variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBmain(this); // Initialize dbHelper in onCreate

        Button btlogin = findViewById(R.id.btlogin);
        EditText usernameEditText  = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        // Check if the provided username and password are valid
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate the username and password from the database
                if (isValidUser(username, password)) {
                    // Username and password are correct, navigate to Menu activity
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    showInvalidCredentialsAlert();

                }
            }
        });
    }

    private boolean isValidUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {"username"};
        String selection = "username=? and password=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(DBmain.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count > 0;
    }

    private void showInvalidCredentialsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Invalid Credentials");
        builder.setMessage("Please enter the correct username and password.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle the OK button click if needed
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
