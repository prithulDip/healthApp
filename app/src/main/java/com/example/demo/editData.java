package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * this class for update data
 * first declare all the id
 *  then two function create
 */
public class editData extends AppCompatActivity {


    EditText date,time,dia,sis,hrate,comment;
    Button editData;

    String idS,dateS,timeS,diaS,sisS,hrateS,commentS;

    /**
     * read all the data from the editText
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        date = findViewById(R.id.Date);
        time = findViewById(R.id.time);
        dia = findViewById(R.id.dia);
        sis = findViewById(R.id.sis);
        hrate = findViewById(R.id.hr);
        comment = findViewById(R.id.comment);
        editData = findViewById(R.id.submit);

        getAndSetIntentData();
/**
 * when press on update button then take all the data
 * then update all the data to the database and make sure refresh the main activity page
 * then start activity to mainActivity
 */
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DBhelper myDB = new DBhelper(editData.this);
                System.out.println(idS);
                        sisS=sis.getText().toString().trim();
                      diaS =  dia.getText().toString().trim();
                                hrateS =  hrate.getText().toString().trim();
                                dateS= date.getText().toString().trim();
                                commentS= comment.getText().toString().trim();
                                timeS=    time.getText().toString().trim();
                myDB.updateData(idS,sisS,diaS,hrateS,dateS,commentS,timeS);
                startActivity(new Intent(editData.this, MainActivity.class));
            }
        });


    }

    /**
     * here first fetch all the data and print on the display according to their id
     * if user change any data and click on update button
     * then all the data will updated in that particular id
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


            //Setting Intent Data
            date.setText(dateS);
            time.setText(timeS);
            dia.setText(diaS);
            sis.setText(sisS);
            hrate.setText(hrateS);
            comment.setText(commentS);
            // Log.d("stev", title+" "+author+" "+pages);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}