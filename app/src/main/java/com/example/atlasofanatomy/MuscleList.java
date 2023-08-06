package com.example.atlasofanatomy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class MuscleList extends Fragment {

    ArrayList<Muscle> muscleArrayList = new ArrayList<Muscle>();

    int [] muscleImages = {R.drawable.trapezius, R.drawable.shirochaishaya_spini, R.drawable.rhomboid_muscles, R.drawable.krestsovo_pozvonochnaya,
            R.drawable.lestnichnie, R.drawable.podkojnaya_shei, R.drawable.lopatochno_podyazichnaya, R.drawable.grudino_shitovidnaya,
            R.drawable.grudino_podyazichnaya, R.drawable.grudino_kluchichno_soscevidnaya, R.drawable.dlinneishaya_shei, R.drawable.bolshaya_grudnaya,
            R.drawable.dlinneishaya_grudi, R.drawable.malaya_grudnaya, R.drawable.bolshaya_kruglaya, R.drawable.malaya_kruglaya,
            R.drawable.deltoid, R.drawable.rotatornaya_manjeta, R.drawable.nadosnaya, R.drawable.kluvovidno_plechevaya,
            R.drawable.biceps_brachii, R.drawable.triceps_brachii, R.drawable.loctevoi_razgibatel, R.drawable.loctevoi_sgibatel,
            R.drawable.gluteus_maximus, R.drawable.quadriceps_muscle, R.drawable.pryamaya_bedra, R.drawable.medialnaya_shirokaya_bedra,
            R.drawable.lateralnaya_shirokaya_bedra, R.drawable.dvuglavaya_bedra, R.drawable.ikronojnaya};

    String [] muscleNames = {"Трапециевидная мышца", "Широчайшая мышца спины", "Ромбовидные мышцы", "Крестцово-позвоночная мышца",
    "Лестничные мышцы", "Подкожная мышца шеи", "Лопаточно-подъязычная мышца", "Грудинощитовидная мышца", "Грудиноподъязычная мышца",
    "Грудино-ключично-сосцевидная мышца", "Длиннейшая мышца шеи", "Большая грудная мышца", "Длиннейшая мышца груди", "Малая грудная мышца",
    "Большая круглая мышца", "Малая круглая мышца", "Дельтовидная мышца", "Ротаторная манжета", "Надостная мышца", "Клювовидно-плечевая мышца",
    "Двуглавая мышца плеча", "Трёхглавая мышца плеча", "Локтевой разгибатель запястья", "Локтевой сгибатель запястья", "Большая ягодичная мышца",
    "Четырехглавая мышца", "Прямая мышца бедра", "Медиальная широкая мышца бедра", "Латеральная широкая мышца бедра", "Двуглавая мышца бедра", "Икроножная мышца"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_muscle_list, container, false);

        setMuscleData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        MuscleAdapter adapter = new MuscleAdapter(getContext(), muscleArrayList);
        recyclerView.setAdapter(adapter);

        if (getArguments() != null) Toast.makeText(getContext(), "Здравствуйте, "+getArguments().getString("name"), Toast.LENGTH_SHORT).show();

        return view;
    }

    private void setMuscleData(){

        for (int i = 0; i < muscleImages.length; i++) muscleArrayList.add(new Muscle(muscleNames[i], muscleImages[i]));

    }
}