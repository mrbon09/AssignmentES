package com.assignment.duy.assignmentes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private CardView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        Info = (TextView)findViewById(R.id.tryagain);
        Login = (CardView)findViewById(R.id.cardView);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginClick(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    @SuppressLint("WrongViewCast")
    public void loginClick(String userName, String userPassword){

        if((userName.equals("mrbon09")) && (userPassword.equals("123456789!"))){
            Intent intent = new Intent(this, MainView.class);
            startActivity(intent);
        }
        else if ((userName.equals("")) || (userPassword.equals(""))){
            Info.setText("Please Enter Username or Password!");
        }
        else{
            Info.setText("Please Try Aigain! ^^");
        }



    }
}
