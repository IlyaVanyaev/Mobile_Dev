package com.example.atlasofanatomy;


import android.os.Bundle;


import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    View view;
    ListView listView;
    ArrayList<Bone> boneArrayList = new ArrayList<Bone>();

    int [] boneImages = {R.drawable.skull, R.drawable.lobnaia_kost, R.drawable.zatilochnaya_kost, R.drawable.visochnaia_kost,
            R.drawable.temennaia_kost, R.drawable.bolshebertsovaya_kost, R.drawable.reshetchataya_kost, R.drawable.grudnaya_kletka,
            R.drawable.grudina, R.drawable.pervoe_i_vtoroe_rebra, R.drawable.pozvonok, R.drawable.lopatka ,R.drawable.kluchica,
            R.drawable.plechevaya_kost, R.drawable.loktevaya_kost, R.drawable.luchevaya_kost, R.drawable.kosti_kisti,
            R.drawable.taz, R.drawable.bedrennaya_kost, R.drawable.kosti_kolennogo_sustava, R.drawable.nadkolennik,
            R.drawable.bolshebertsovaya_kost, R.drawable.malobertsovaya_kost, R.drawable.stopa, R.drawable.piatochnaia_kost};

    String [] boneNames = {"Череп", "Лобная кость", "Затылочная кость", "Височная кость", "Теменная кость", "Клиновидная кость",
    "Решетчатая кость", "Грудная клетка", "Грудина", "Ребра", "Позвоночный столб", "Лопатка", "Ключица", "Плечевая кость",
    "Локтевая кость", "Лучевая кость", "Кисть", "Таз", "Бедренная кость", "Коленный сустав", "Надколенник", "Болщеберцовая кость",
    "Малоберцовая кость", "Стопа", "Пяточная кость"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_second, container, false);

        setBoneData();
        setListView();

        return view;
    }

    private void setBoneData(){
        for (int i = 0; i < boneImages.length; i++) {
            Bone bone = new Bone(boneNames[i], boneImages[i]);
            boneArrayList.add(bone);
        }
    }

    private void setListView(){
        listView = view.findViewById(R.id.list_view);
        BoneAdapter boneAdapter = new BoneAdapter(getActivity().getApplicationContext(), R.layout.bone_view, boneArrayList);
        listView.setAdapter(boneAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bone selectedBone = (Bone) (listView.getItemAtPosition(position));
                Toast.makeText(getContext(), selectedBone.getName(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, selectedBone.getName());
            }
        });
    }


}