package com.example.atlasofanatomy;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    TextView lastLog;

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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button push");

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("NAME", et.getText().toString());
                result.launch(intent);
            }
        });


        ImageView iv1 = (ImageView) findViewById(R.id.main_image);
        iv1.setImageResource(R.drawable.scale_1200);

        ImageView iv2 = (ImageView) findViewById(R.id.second_main_image);
        iv2.setImageResource(R.drawable.mus_anat);

        ImageView iv3 = (ImageView) findViewById(R.id.main_png);
        iv3.setImageResource(R.drawable.pngegg);

        lastLog = findViewById(R.id.last_log_in);
    }


    ActivityResultLauncher<Intent> result = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onActivityResult(ActivityResult result) {

            if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null){
                Toast.makeText(MainActivity.this, "buy, " + result.getData().getStringExtra("NAME"), Toast.LENGTH_SHORT).show();
                lastLog.setText("last log in was made by " + result.getData().getStringExtra("NAME"));
            }

        }
    });


}