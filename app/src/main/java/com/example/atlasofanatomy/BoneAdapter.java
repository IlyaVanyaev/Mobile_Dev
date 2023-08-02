package com.example.atlasofanatomy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BoneAdapter extends ArrayAdapter<Bone> {

    public BoneAdapter(@NonNull Context context, int resource, @NonNull List<Bone> boneList) {
        super(context, resource, boneList);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Bone bone = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.bone_view, parent,false);

        ImageView iv = convertView.findViewById(R.id.bone_image);
        TextView tv = convertView.findViewById(R.id.bone_name);
        iv.setImageResource(bone.getImage());
        tv.setText(bone.getName());

        return convertView;
    }
}
