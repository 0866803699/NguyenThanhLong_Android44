package com.example.fooddelivery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.Viewhoder> {
    private List<ItemFood> itemfood;
    private Context Context;
    IonClickContact ionClickContact;
    SharedPreferences sharedPreferences;

    public FoodAdapter(List<ItemFood> itemfood, android.content.Context context) {
        this.itemfood = itemfood;
        Context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setIonClickContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    @Override
    public Viewhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_custom_item, parent, false);

        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(FoodAdapter.Viewhoder holder, @SuppressLint("RecyclerView") int position) {
        final ItemFood itemFood = itemfood.get(position);

        holder.tvName.setText(itemFood.getNameFood());
        holder.tvPrice.setText(itemFood.getPrice());
        boolean fullMode =sharedPreferences.getBoolean("full_mode",true);

        if (fullMode) {
            holder.Favo.setVisibility(View.VISIBLE);
            holder.Item.setVisibility(View.VISIBLE);
            holder.Star.setVisibility(View.VISIBLE);
            holder.Star2.setVisibility(View.VISIBLE);
            holder.Star3.setVisibility(View.VISIBLE);
            holder.Star4.setVisibility(View.VISIBLE);
            holder.Star5.setVisibility(View.VISIBLE);
            holder.Add.setVisibility(View.VISIBLE);
        }else {
            holder.Favo.setVisibility(View.GONE);
            holder.Item.setVisibility(View.GONE);
            holder.Star.setVisibility(View.GONE);
            holder.Star2.setVisibility(View.GONE);
            holder.Star3.setVisibility(View.GONE);
            holder.Star4.setVisibility(View.GONE);
            holder.Star5.setVisibility(View.GONE);
            holder.Add.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return itemfood.size();
    }

    public class Viewhoder extends ViewHolder {
        TextView tvName, tvPrice;
        ImageView Favo,Item,Star,Star2,Star3,Star4,Star5,Add;
        public Viewhoder( View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            Favo= itemView.findViewById(R.id.imFavorite);
            Item=itemView.findViewById(R.id.imItem);
            Star= itemView.findViewById(R.id.imStar1);
            Star4= itemView.findViewById(R.id.imStar4);
            Star2= itemView.findViewById(R.id.imStar2);
            Star3= itemView.findViewById(R.id.imStar3);
            Star5= itemView.findViewById(R.id.imStar5);
            Add= itemView.findViewById(R.id.btnAdd);
        }
    }
}
