package com.example.atlasofanatomy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    Intent intent;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = findViewById(R.id.second_text);
        intent = getIntent();
        String name = intent.getStringExtra("NAME");
        tv.setText("Welcome, " + name + "!");

    }

    @Override
    public void onBackPressed() {

        intent.putExtra("NAME", intent.getStringExtra("NAME"));
        setResult(RESULT_OK, intent);
        finish();

    }
}