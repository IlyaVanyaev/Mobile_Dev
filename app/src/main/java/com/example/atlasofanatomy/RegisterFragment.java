package com.example.atlasofanatomy;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class RegisterFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    TextView lastLog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);


        TextView tv1 = (TextView) view.findViewById(R.id.main_string);
        tv1.setText(R.string.anatomy);

        TextView tv2 = (TextView) view.findViewById(R.id.main_welcome);
        tv2.setText(R.string.welcome);

        EditText et = (EditText) view.findViewById(R.id.main_type_name);
        et.setHint(R.string.type_name);

        Button b = (Button) view.findViewById(R.id.main_sign_in_button);
        b.setText(R.string.sign);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button push");

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                SecondFragment sf = new SecondFragment();
                ft.replace(R.id.main_container, sf);
                ft.commit();

            }
        });


        ImageView iv1 = (ImageView) view.findViewById(R.id.main_image);
        iv1.setImageResource(R.drawable.scale_1200);

        ImageView iv2 = (ImageView) view.findViewById(R.id.second_main_image);
        iv2.setImageResource(R.drawable.mus_anat);

        ImageView iv3 = (ImageView) view.findViewById(R.id.main_png);
        iv3.setImageResource(R.drawable.pngegg);

        lastLog = view.findViewById(R.id.last_log_in);

        return view;

    }
}