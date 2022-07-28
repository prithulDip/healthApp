package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; // layout create by recyclerView
    FloatingActionButton floatingActionButton; // here a add button to add data
    DBhelper DB;//object of the database class
    ArrayList<String> id,date,time,s,d,h,comment;//arraylist for the all data
    CustomAdapter customAdapter;

    /**
     * first identify all the id
     * @param savedInstanceState
     * declare databse DB object here in this class
     * initialize all the array lists here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        DB = new DBhelper(MainActivity.this);
        id =new ArrayList<>();
        date =new ArrayList<>();
        time =new ArrayList<>();
        s =new ArrayList<>();
        d =new ArrayList<>();
        h =new ArrayList<>();
        comment =new ArrayList<>();

        addValuesIntoArray();// add array value in recyclerView item

        customAdapter = new CustomAdapter(MainActivity.this,this,id,date,time,s,d,h,comment);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        /**
         * when press on the floating button it will go the Adding_data activity
         */
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Adding_data.class);
                startActivity(intent);
            }
        });
    }

    /**
     * after update or delete data then the page will refresh
     * @param requestCode when data base updated then it will be one
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    /**
     * using the cursor object
     * readAllData is the function created in DBhelper
     * if cursor count = 0, then there is no data
     * else cursor move to next method
     * then take the all value by column index value
     */
    void addValuesIntoArray(){
        Cursor cursor = DB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "NO DATA..!", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                date.add(cursor.getString(4));
                time.add(cursor.getString(5));
                s.add(cursor.getString(1));
                d.add(cursor.getString(2));
                h.add(cursor.getString(3));
                comment.add(cursor.getString(6));

            }
        }
    }
}