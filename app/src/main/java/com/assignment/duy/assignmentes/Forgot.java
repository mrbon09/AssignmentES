package com.assignment.duy.assignmentes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Forgot extends AppCompatActivity {
    String str;
    EditText edit;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_forgot);
        TextView text = findViewById(R.id.textView8);
        text.setTextColor(Color.BLUE);
        Button confirm = findViewById(R.id.button2);
        Button back = findViewById(R.id.button1);
        edit=findViewById(R.id.editText);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=edit.getText().toString().trim();
                if (str.equals("") == true)
                    Toast.makeText(Forgot.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                else if(!str.contains(".") || !str.contains("@"))
                    Toast.makeText(Forgot.this, "Please enter in right format", Toast.LENGTH_SHORT).show();
                else
                    {
                        Toast.makeText(Forgot.this, "Verified. We will send you confirmed email ", Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(Forgot.this, MainActivity.class);
                        startActivity(in);
                    }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Forgot.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}