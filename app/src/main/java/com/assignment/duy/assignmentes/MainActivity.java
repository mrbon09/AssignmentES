package com.assignment.duy.assignmentes;
/*
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
    public void loginClick(String userName, String userPassword) {

        if ((userName.equals("mrbon09")) && (userPassword.equals("123456789!"))) {
            Intent intent = new Intent(this, MainView.class);
            startActivity(intent);
        } else if ((userName.equals("")) || (userPassword.equals(""))) {
            Info.setText("Please Enter Username or Password!");
        } else {
            Info.setText("Please Try Aigain! ^^");
        }
    }



    public void loginClick(View view){
        Intent intent = new Intent(this, MainView.class);
        startActivity(intent);
    }
}
*/
import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private CardView Login;
    private Button register, forgot;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FrameLayout frame;
        frame=findViewById(R.id.main);
        Name = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        Info = (TextView)findViewById(R.id.tryagain);
        Login = (CardView)findViewById(R.id.cardView);
        register=findViewById(R.id.button1);
        forgot=findViewById(R.id.button2);
        db=new DatabaseHelper(this);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginClick(Name.getText().toString(), Password.getText().toString());
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClassName("com.assignment.duy.assignmentes","com.assignment.duy.assignmentes.Register");
                startActivity(intent);

            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent();
                in.setClassName("com.assignment.duy.assignmentes","com.assignment.duy.assignmentes.Forgot");
                startActivity(in);

            }
        });

    }
    @SuppressLint("WrongViewCast")
    public void loginClick(String userName, String userPassword)
    {
        if(userName.equals("")==true || userPassword.equals("")==true)
            Toast.makeText(this,"Please Enter Username or Password!",Toast.LENGTH_SHORT).show();
        else
            {
            boolean res = db.checkUser(userName, userPassword);
            if (res == true)
                {
                    Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainView.class);
                    startActivity(intent);
                }
                else  Toast.makeText(this, "Please register first", Toast.LENGTH_SHORT).show();
            }
    }
}
