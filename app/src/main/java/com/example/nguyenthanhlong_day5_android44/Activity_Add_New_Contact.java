package com.example.nguyenthanhlong_day5_android44;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Activity_Add_New_Contact extends AppCompatActivity {
    ListView lvList2;
    TextView price2;
    List<Product> products2;
    AdapterProduct adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact2);
        lvList2= findViewById(R.id.lvList2);
        price2= findViewById(R.id.price);
        products2=new ArrayList<>();


        Intent intent = getIntent();
        String nameAdd =intent.getStringExtra("name");
        products2.add( new Product(nameAdd));
        adapterProduct= new AdapterProduct((ArrayList<Product>) products2);
        lvList2.setAdapter(adapterProduct);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}