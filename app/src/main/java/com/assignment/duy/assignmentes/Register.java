package com.assignment.duy.assignmentes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Register extends AppCompatActivity {
    EditText textUser,textPassword,textConfirm,textEmail;
    String user,password,confirm,email;
    DatabaseHelper db;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        Button ok = findViewById(R.id.button2);
        Button back = findViewById(R.id.button1);
        textUser = findViewById(R.id.editText);
        textPassword = findViewById(R.id.editText2);
        textConfirm = findViewById(R.id.editText3);
        textEmail=findViewById(R.id.editText4);
        db=new DatabaseHelper(this);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = textUser.getText().toString().trim();
                password = textPassword.getText().toString().trim();
                confirm = textConfirm.getText().toString().trim();
                email = textEmail.getText().toString().trim();
                if (password.equals(confirm) && user.equals("") == false && password.equals("") == false && email.equals("") == false) {
                    long val = db.addUser(user, password);
                    if (val >= 0) {
                        Toast.makeText(Register.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(Register.this, MainActivity.class);
                        startActivity(in);
                    } else
                        Toast.makeText(Register.this, " Registeration error.Already existed account ", Toast.LENGTH_SHORT).show();
                } else {
                    if (email.equals("") == true || !Patterns.EMAIL_ADDRESS.matcher(email).matches() || (!email.contains("gmail.com") && !email.contains("yahoo.com")) )
                        Toast.makeText(Register.this, "Please enter your right email", Toast.LENGTH_SHORT).show();
                    else if (user.equals("") == true || user.length() > 15) {
                        if (user.equals("") == true)
                            Toast.makeText(Register.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Register.this, "cannot have more than 15 characters", Toast.LENGTH_SHORT).show();
                    } else if (password.equals(confirm) == false)
                        Toast.makeText(Register.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Register.this, MainActivity.class);
                startActivity(in);
            }
        });

    }
}