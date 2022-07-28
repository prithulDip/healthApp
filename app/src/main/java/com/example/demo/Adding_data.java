package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * this class for add data to the sql lite database
 */
public class Adding_data extends AppCompatActivity {
    EditText dateInput,timeInput,sisInput,diaInput,HrateInput,commentInput;
    Button submit;

    /**
     * here find the id and put in the editText and Button type
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_data);

        dateInput =findViewById(R.id.Date);
        timeInput = findViewById(R.id.time);
        sisInput = findViewById(R.id.sis);
        diaInput =findViewById(R.id.dia);
        HrateInput = findViewById(R.id.hr);
        commentInput = findViewById(R.id.comment);
        submit = findViewById(R.id.submit);
/**
 * after inserting all the data press on submit button
 * this will insert all the data and call the function addEntry
 * addEntry function is created on DBhelper class
 * here pass all the data there
 */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper db = new DBhelper(Adding_data.this);
                db.addEntry(sisInput.getText().toString().trim(),
                        diaInput.getText().toString().trim(),
                        HrateInput.getText().toString().trim(),
                        dateInput.getText().toString().trim(),
                        commentInput.getText().toString().trim(),
                        timeInput.getText().toString().trim());
               // Intent intent = new Intent(Adding_data.this,Adding_data.class);
            }
        });

    }
}