package com.example.mealzj;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.domain.entity.Category;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.qualifiers.ActivityContext;


public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {
    ArrayList<Category> myList = new ArrayList<>();
    Context context;

    public MealsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {

        holder.name.setText(myList.get(position).getStrCategory());
        holder.desc.setText(myList.get(position).getStrCategoryDescription());
        holder.img.setImageURI(Uri.parse(myList.get(position).getStrCategoryThumb()));
        Glide.with(context).load(myList.get(position).getStrCategoryThumb()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public void setList(ArrayList<Category> myList) {
        this.myList = myList;
        notifyDataSetChanged();
    }

    public class MealsViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name, desc;
        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.category_iv);
            name = itemView.findViewById(R.id.category_name_tv);
            desc = itemView.findViewById(R.id.category_des_tv);
        }
    }
}
