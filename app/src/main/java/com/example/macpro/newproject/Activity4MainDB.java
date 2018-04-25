package com.example.macpro.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4MainDB extends AppCompatActivity {
    Button btAdd, btView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_main_db);

        btAdd = findViewById(R.id.butAdd);
        btView = findViewById(R.id.butView);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Activity5Add.class);
                startActivity(intent);
            }
        });
        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ActivityView.class);
                startActivity(intent);
            }
        });
    }
}
