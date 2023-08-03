package com.example.atlasofanatomy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MuscleAdapter extends RecyclerView.Adapter<MuscleAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Muscle> muscles;

    MuscleAdapter(Context context, List<Muscle> muscles){
        this.muscles = muscles;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MuscleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.muscle_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuscleAdapter.ViewHolder holder, int position) {

        Muscle muscle = muscles.get(position);
        holder.iv.setImageResource(muscle.getImage());
        holder.tv.setText(muscle.getName());

    }

    @Override
    public int getItemCount() {
        return muscles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;

        ViewHolder(View view){
            super(view);
            iv = view.findViewById(R.id.muscle_image);
            tv = view.findViewById(R.id.muscle_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        Toast.makeText(view.getContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
                        Log.d(MuscleList.class.getSimpleName(), tv.getText().toString());
                    }
                }
            });
        }

    }


}

