package com.mireia.recyclerejercicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.FoodViewHolder> {

    private ArrayList<Food> foodList;

    public MiAdaptador(ArrayList<Food> foodList){
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MiAdaptador.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MiAdaptador.FoodViewHolder foodViewHolder =
                new FoodViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card, parent, false)
                );

        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.imageView.setImageResource(food.getImage());
        holder.tv_title.setText(food.getTitle());
        holder.tv_getit.setText(food.getGetit().toString());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_title;
        TextView tv_getit;

        public FoodViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_getit = itemView.findViewById(R.id.tv_getit);

        }
    }


}
