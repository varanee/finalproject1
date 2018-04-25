package com.example.macpro.newproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2Login extends AppCompatActivity {

    Button btLogin;
    AutoCompleteTextView tvUsername, tvPassword;
    TextView tvRegister;
    UserManage userManage;
    Context con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_login);

        btLogin = findViewById(R.id.butLogin);
        tvUsername = findViewById(R.id.textUsername);
        tvPassword = findViewById(R.id.textPassword);
        tvRegister = findViewById(R.id.textRegister);
        con = this;
        userManage = new UserManage(con);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tvUsername.getText().toString();
                String password = tvPassword.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input User name !!", Toast.LENGTH_SHORT).show();
                    tvUsername.requestFocus();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input Password !!", Toast.LENGTH_SHORT).show();
                    tvPassword.requestFocus();
                } else {
                    boolean isSuccess = userManage.checkLoginValidate(username, password);
                    if (isSuccess) {
                        Intent intent = new Intent(getApplication(), Activity4MainDB.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Activity3Register.class);
                startActivity(intent);
            }
        });
    }
}


