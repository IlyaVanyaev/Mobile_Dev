package com.example.atlasofanatomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        CharSequence text = "onCreate worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.i(TAG, "onCreate info log");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Context context = getApplicationContext();
        CharSequence text = "onStart worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.i(TAG, "onStart info log");
        Log.e(TAG, "onStart error log");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Context context = getApplicationContext();
        CharSequence text = "onStop worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.i(TAG, "onStop info log");
        Log.w(TAG, "onStop warning log");
        Log.d(TAG, "onStop debug log");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Context context = getApplicationContext();
        CharSequence text = "onDestroy worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.i(TAG, "onDestroy info log");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Context context = getApplicationContext();
        CharSequence text = "onPause worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.i(TAG, "onPause info log");
        Log.v(TAG, "onPause verbose log");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Context context = getApplicationContext();
        CharSequence text = "onResume worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.i(TAG, "onResume info log");
    }
}