package com.example.atlasofanatomy;


import static androidx.core.content.ContextCompat.getSystemService;
import android.Manifest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
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
import android.widget.Toast;


public class RegisterFragment extends Fragment {

    private final String CHANNEL_ID = "register_channel";
    private final int NOTIFICATION_ID = 1;

    private final ActivityResultLauncher<String> resultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
     if (isGranted) Toast.makeText(getContext(), "Permission granted", Toast.LENGTH_SHORT).show();
    });

    EditText et;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createNotificationChannel();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);


        TextView tv1 = view.findViewById(R.id.main_string);
        tv1.setText(R.string.anatomy);


        et = view.findViewById(R.id.main_type_name);
        et.setHint(R.string.type_name);

        Button bones = view.findViewById(R.id.main_bones);
        bones.setText(R.string.bones);

        Button muscles = view.findViewById(R.id.main_muscles);
        muscles.setText(R.string.muscles);

        Button notification = view.findViewById(R.id.main_notification);

        ImageView iv1 = view.findViewById(R.id.main_image);
        iv1.setImageResource(R.drawable.scale_1200);

        ImageView iv2 = view.findViewById(R.id.second_main_image);
        iv2.setImageResource(R.drawable.mus_anat);

        ImageView iv3 = view.findViewById(R.id.main_png);
        iv3.setImageResource(R.drawable.pngegg);


        bones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!et.getText().toString().equals("")){
                    Bundle bundle = new Bundle();
                    bundle.putString("name", et.getText().toString());
                    Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_secondFragment, bundle);
                } else Toast.makeText(getContext(), "Введите ваше имя, пожалуйста", Toast.LENGTH_SHORT).show();

            }
        });

        muscles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!et.getText().toString().equals("")){
                    Bundle bundle = new Bundle();
                    bundle.putString("name", et.getText().toString());
                    Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_muscleList, bundle);
                } else Toast.makeText(getContext(), "Введите ваше имя, пожалуйста", Toast.LENGTH_SHORT).show();

            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED){
                    showNotification();
                } else resultLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        });

        return view;

    }

    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.muscle)
                .setContentTitle(getString(R.string.anatomy))
                .setContentText("Welcome to the Anatomy")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat manager = NotificationManagerCompat.from(getContext());
        manager.notify(NOTIFICATION_ID, builder.build());

    }

    private void createNotificationChannel(){

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "RegisterChannel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) getActivity().getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);

    }

}