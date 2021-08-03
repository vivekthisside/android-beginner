package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewM2 = findViewById(R.id.textViewM2);
        Intent intent = getIntent();
        String stringname = intent.getStringExtra(MainActivity.keyvalue);
        textViewM2.setText("hello  " + stringname);

    }
}