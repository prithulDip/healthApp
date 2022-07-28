package com.example.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 *A class to show data and proceed to update or delete data.
 */

public class ShowData extends AppCompatActivity {

    TextView date,time,dia,sis,hrate,comment;
    Button editData, deleteData;

    String idS,dateS,timeS,diaS,sisS,hrateS,commentS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        date = findViewById(R.id.Date);
        time = findViewById(R.id.time);
        dia = findViewById(R.id.dia);
        sis = findViewById(R.id.sis);
        hrate = findViewById(R.id.hr);
        comment = findViewById(R.id.comment);
        editData = findViewById(R.id.edit_button);
        deleteData = findViewById(R.id.delete_button);

        getAndSetIntentData();//Getting and setting data from intent.

        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowData.this, editData.class);
                intent.putExtra("id", idS);
                intent.putExtra("date", dateS);
                intent.putExtra("time", timeS);
                intent.putExtra("dia", diaS);
                intent.putExtra("sis", sisS);
                intent.putExtra("Hrate", hrateS);
                intent.putExtra("Comment", commentS);
                startActivity(intent);
            }
        });
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });


    }

    /**
     * retrieve data from previous intent
     * then set then into present intent
     */
    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("date") &&
                getIntent().hasExtra("time") &&
                getIntent().hasExtra("dia") &&
                getIntent().hasExtra("sis") && getIntent().hasExtra("Hrate") && getIntent().hasExtra("Comment")) {


            //Getting Data from Intent
            idS = getIntent().getStringExtra("id");
            dateS = getIntent().getStringExtra("date");
            timeS = getIntent().getStringExtra("time");
            diaS = getIntent().getStringExtra("dia");
            sisS = getIntent().getStringExtra("sis");
            hrateS = getIntent().getStringExtra("Hrate");
            commentS = getIntent().getStringExtra("Comment");

            System.out.println(idS);

            //Setting Intent Data
            date.setText(dateS);
            time.setText(timeS);
            dia.setText(diaS);
            sis.setText(sisS);
            hrate.setText(hrateS);
            comment.setText(commentS);

        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A fumction that gets confirmations form the user if he wants to delete the data
     */
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + dateS + " ?");
        builder.setMessage("Are you sure you want to delete " + dateS + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBhelper myDB = new DBhelper(ShowData.this);
                myDB.deleteOneRow(idS);//called delete data method form DBhelper
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();//Creates the pop up window before deleting
    }
}