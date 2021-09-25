package com.example.fooddelivery;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityHomePage extends AppCompatActivity {
    ActivityHomePageBinding binding;
    List<ItemFood> itemFood;
    List<ItemFood>itemFoodNew;
    List<ItemFood>itemFoodHot;
    SharedPreferences preferences;
    FoodAdapter FoodAdapter;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = preferences.edit();

        itemFood = new ArrayList<ItemFood>();

        itemFood.add(new ItemFood("Ribeye steak","$12,5",true,true,true,true,true,true,true,true));
        itemFood.add(new ItemFood("Baked salmon","$14,8",true,true,true,true,true,true,true,true));
        itemFood.add(new ItemFood("Vegas","$7,2",true,true,true,true,true,true,true,true));
        itemFood.add(new ItemFood("Roasted chicken","$16,5",true,true,true,true,true,true,true,true));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.HORIZONTAL, false);
        FoodAdapter = new FoodAdapter(itemFood,this);
        binding.rvRecommended.setLayoutManager(layoutManager);
        binding.rvRecommended.setAdapter(FoodAdapter);

        itemFoodNew = new ArrayList<ItemFood>();

        itemFoodNew.add(new ItemFood("Chicken salad","$7,5",true,true,true,true,true,true,true,true));
        itemFoodNew.add(new ItemFood("Nut toast","$8,7",true,true,true,true,true,true,true,true));
        itemFoodNew.add(new ItemFood("Eggs","$12,4",true,true,true,true,true,true,true,true));
        itemFoodNew.add(new ItemFood("french beef","$13,5",true,true,true,true,true,true,true,true));
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.HORIZONTAL, false);
        FoodAdapter = new FoodAdapter(itemFood, this);
        binding.rvNew.setLayoutManager(layoutManager2);
        binding.rvNew.setAdapter(FoodAdapter);

        itemFoodHot = new ArrayList<ItemFood>();

        itemFoodHot.add(new ItemFood("Ribeyes steak","$12,5",true,true,true,true,true,true,true,true));
        itemFoodHot.add(new ItemFood("Baked salmon","$14,8",true,true,true,true,true,true,true,true));
        itemFoodHot.add(new ItemFood("Vegas","$7,2",true,true,true,true,true,true,true,true));
        itemFoodHot.add(new ItemFood("Roasted chicken","$16,5",true,true,true,true,true,true,true,true));
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.HORIZONTAL, false);
        FoodAdapter = new FoodAdapter(itemFood, getBaseContext());
        binding.rvHot.setLayoutManager(layoutManager3);
        binding.rvHot.setAdapter(FoodAdapter);

    }
}