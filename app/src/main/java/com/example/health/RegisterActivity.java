package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    FirebaseDatabase firebase;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText regUserName = findViewById(R.id.inputUserName);
        EditText regUserPhone = findViewById(R.id.loginPhone);
        EditText regUserPassword = findViewById(R.id.loginPassword);
        EditText regUserConfirmPassword = findViewById(R.id.inputPasswordConfirm);
        EditText regUserEmail = findViewById(R.id.inputEmail);
        Button regButton = findViewById(R.id.btnLogin);
        TextView alreadyReg = findViewById(R.id.haveAnAccount);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebase = FirebaseDatabase.getInstance();
                reference = firebase.getReference("users");

                //get all the variable
                String userName =  regUserName.getText().toString();
                String userPhone =  regUserPhone.getText().toString();
                String userEmail =  regUserEmail.getText().toString();
                String userPass =  regUserPassword.getText().toString();
                String userConfirmPass =  regUserConfirmPassword.getText().toString();

                RegisterHelper helperClass = new RegisterHelper(userName, userPhone, userEmail, userPass, userConfirmPass);
                reference.child(userPhone).setValue(helperClass);

                startActivity(new Intent(RegisterActivity.this, MainActivity.class));


            }
        });
    }
}