package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static final String keyvalue = "abcd.extra.NAME";
EditText yournamehere;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void buttonactivity(View v){
        Toast.makeText(this, "wow next page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        yournamehere = findViewById(R.id.yournamehere);
        String yourname = yournamehere.getText().toString();
        intent.putExtra(keyvalue,yourname);
        startActivity(intent);
    }
}