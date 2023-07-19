package com.example.atlasofanatomy;

import androidx.appcompat.app.AppCompatActivity;

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
                startActivity(intent);
            }
        });


        ImageView iv1 = (ImageView) findViewById(R.id.main_image);
        iv1.setImageResource(R.drawable.scale_1200);

        ImageView iv2 = (ImageView) findViewById(R.id.second_main_image);
        iv2.setImageResource(R.drawable.mus_anat);

        ImageView iv3 = (ImageView) findViewById(R.id.main_png);
        iv3.setImageResource(R.drawable.pngegg);
    }


}