package com.example.atlasofanatomy;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main_container,RegisterFragment.class,null)
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {

        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        RegisterFragment rf = new RegisterFragment();
        ft.replace(R.id.main_container, rf);
        ft.commit();
    }
}