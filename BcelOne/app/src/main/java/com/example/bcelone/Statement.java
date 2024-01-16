package com.example.bcelone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

public class Statement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView courseRV = findViewById(R.id.idRVCourse);

        // Here, we have created a new array list and added data to it
        ArrayList<Model> modelArrayList = new ArrayList<>();
        modelArrayList.add(new Model("user1", "pass1", "ໄດ້ຮັບເງິນໂອນ", "ຄ່ານົມ", R.drawable.income, "999,999", "THEP SOUKVIXAY"));
        modelArrayList.add(new Model("user2", "pass2", "ໄດ້ຮັບເງິນໂອນ", "ຄ່ານົມ", R.drawable.income, "999,999", "THEP SOUKVIXAY"));


        // We are initializing our adapter class and passing our array list to it.
        Adapter adapter = new Adapter(this, modelArrayList);

        // Below line is for setting a layout manager for our recycler view.
        // Here we are creating a vertical list, so we will provide orientation as vertical.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // In the next two lines, we are setting the layout manager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(adapter);


    }
}
