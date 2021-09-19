package com.example.nguyenthanhlong_day5_android44;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(),ActivityAddProduct.class);
                startActivity(intent);
            }
        });
    }
}