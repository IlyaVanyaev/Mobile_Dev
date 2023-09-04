package com.example.atlasofanatomy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onPause() {
        startService(new Intent(this, BannerService.class));
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stopService(new Intent(this, BannerService.class));
    }


    @Override
    protected void onDestroy() {
        stopService(new Intent(this, BannerService.class));
        super.onDestroy();
    }

}