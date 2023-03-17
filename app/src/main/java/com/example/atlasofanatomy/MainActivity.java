package com.example.atlasofanatomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView) findViewById(R.id.main_string);
        tv1.setText(R.string.anatomy);

        TextView tv2 = (TextView) findViewById(R.id.main_welcome);
        tv2.setText(R.string.welcome);

        EditText et = (EditText) findViewById(R.id.main_type_name);
        et.setHint(R.string.type_name);

        Button b = (Button) findViewById(R.id.main_sign_in_button);
        b.setText(R.string.sign);

        ImageView iv1 = (ImageView) findViewById(R.id.main_image);
        iv1.setImageResource(R.drawable.scale_1200);

        ImageView iv2 = (ImageView) findViewById(R.id.second_main_image);
        iv2.setImageResource(R.drawable.mus_anat);

        ImageView iv3 = (ImageView) findViewById(R.id.main_png);
        iv3.setImageResource(R.drawable.pngegg);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Context context = getApplicationContext();
        CharSequence text = "onStart worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.d(TAG, "onStart debug log");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Context context = getApplicationContext();
        CharSequence text = "onStop worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

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

        Log.d(TAG, "onPause debug log");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Context context = getApplicationContext();
        CharSequence text = "onResume worked";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        Log.d(TAG, "onResume debug log");
    }
}