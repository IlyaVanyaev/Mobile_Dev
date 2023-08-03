package com.example.atlasofanatomy;


import android.os.Bundle;


import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class RegisterFragment extends Fragment {

    TextView lastLog;
    EditText et;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);


        TextView tv1 = view.findViewById(R.id.main_string);
        tv1.setText(R.string.anatomy);

        TextView tv2 = view.findViewById(R.id.main_welcome);
        tv2.setText(R.string.welcome);

        et = view.findViewById(R.id.main_type_name);
        et.setHint(R.string.type_name);

        Button bones = view.findViewById(R.id.main_bones);
        bones.setText(R.string.bones);

        Button muscles = view.findViewById(R.id.main_muscles);
        muscles.setText(R.string.muscles);

        ImageView iv1 = view.findViewById(R.id.main_image);
        iv1.setImageResource(R.drawable.scale_1200);

        ImageView iv2 = view.findViewById(R.id.second_main_image);
        iv2.setImageResource(R.drawable.mus_anat);

        ImageView iv3 = view.findViewById(R.id.main_png);
        iv3.setImageResource(R.drawable.pngegg);

        lastLog = view.findViewById(R.id.last_log_in);

        bones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_secondFragment);

            }
        });

        muscles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_muscleList);

            }
        });

        return view;

    }

}