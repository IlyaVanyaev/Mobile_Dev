package com.example.atlasofanatomy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SecondFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    TextView tv;
    Button b;
    String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, TAG + " onCreate");
        Toast.makeText(getContext(), TAG + " onCreate", Toast.LENGTH_SHORT).show();

    }



    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        tv = view.findViewById(R.id.second_text);

        getParentFragmentManager().setFragmentResultListener("REQUEST_TO_SECOND_FRAGMENT", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                name = result.getString("NAME");
                tv.setText("Welcome, " + name + "!");
            }
        });



        b = view.findViewById(R.id.log_out_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle result = new Bundle();
                result.putString("NAME", name);
                getParentFragmentManager().setFragmentResult("REQUEST_TO_REGISTER_FRAGMENT", result);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                RegisterFragment rf = new RegisterFragment();
                ft.replace(R.id.main_container, rf);
                ft.commit();
            }
        });

        Log.d(TAG, TAG + " onCreateView");
        Toast.makeText(getContext(), TAG + " onCreateView", Toast.LENGTH_SHORT).show();

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.d(TAG, TAG + " onAttach");
        Toast.makeText(getContext(), TAG + " onAttach", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, TAG + " onStart");
        Toast.makeText(getContext(), TAG + " onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, TAG + " onResume");
        Toast.makeText(getContext(), TAG + " onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, TAG + " onPause");
        Toast.makeText(getContext(), TAG + " onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, TAG + " onStop");
        Toast.makeText(getContext(), TAG + " onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, TAG + " onDestroyView");
        Toast.makeText(getContext(), TAG + " onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, TAG + " onDestroy");
        Toast.makeText(getContext(), TAG + " onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d(TAG, TAG + " onDetach");
        Toast.makeText(getContext(), TAG + " onDetach", Toast.LENGTH_SHORT).show();
    }
}