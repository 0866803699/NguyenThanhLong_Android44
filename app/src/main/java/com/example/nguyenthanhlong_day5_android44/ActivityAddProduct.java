package com.example.nguyenthanhlong_day5_android44;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityAddProduct extends AppCompatActivity{
    ListView lvList;
    List<Product> products;
    Product product,product01,product02,product03,product04,product05;
    TextView price;
    Button btnOder;



    AdapterProduct adapterProduct;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        lvList= findViewById(R.id.lvList);
        price=findViewById(R.id.price);
        btnOder=findViewById(R.id.btnOder);
        products = new ArrayList<>();

        product= new Product("Pizza Panda");
        product01= new Product("KFC Super");
        product02= new Product("Bread Eggs");
        product03= new Product("Coca Cola");
        product04= new Product("Chicken Super");
        product05= new Product("Cup Cake");

        products.add(product);
        products.add(product01);
        products.add(product02);
        products.add(product03);
        products.add(product04);
        products.add(product05);
        adapterProduct = new AdapterProduct((ArrayList<Product>) products);
        lvList.setAdapter(adapterProduct);

        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = preferences.edit();
        btnOder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String oder ="Thank you! Your order is sent to restaurant!";
                Toast.makeText(getApplicationContext(), oder, Toast.LENGTH_LONG).show();
            }
        });
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int i , long l) {
                String name= products.get(i).getName();
                Intent intent = new Intent(ActivityAddProduct.this,Activity_Add_New_Contact.class);
                intent.putExtra("name", name);
                Toast.makeText(ActivityAddProduct.this , ""+products.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.shopmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(ActivityAddProduct.this,Activity_Add_New_Contact.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }



}