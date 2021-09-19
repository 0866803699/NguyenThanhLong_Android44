package com.example.createnewnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.createnewnote.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Calendar cal = Calendar.getInstance();
    int gio = cal.get(Calendar.HOUR_OF_DAY);
    int phut= cal.get(Calendar.MINUTE);
    int ngay = cal.get(Calendar.DATE);
    int thang = cal.get(Calendar.MONTH);
    int nam= cal.get(Calendar.YEAR);
    List<Product> products;
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        products =ProductDataUtils.getProducts();
        registerForContextMenu(binding.btnPopupMenu);
        binding.tvTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSelectTime();
            }
        });
        binding.tvTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSelectDate();
            }
        });
        AdapterProduct adapterProduct = new AdapterProduct(MainActivity.this,
                R.layout.spiner_item,
                R.id.tvItemSpn,products
                );

       binding.spnType.setAdapter(adapterProduct);
       binding.btnMutiChoose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String[] strings= {"Family","Game","Android","VTC","Friend"};
               String[] list=new String[1];
               boolean[] booleans={false,true,false,false,false};
               boolean a = true;
               AlertDialog alertDialog= new AlertDialog.Builder(MainActivity.this)
                       .setTitle("choose tags")
                       .setMultiChoiceItems(strings , booleans , new DialogInterface.OnMultiChoiceClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface , int i , boolean b) {
                               if(b){
                                   boolean a=b;
                               }
                           }

                       })
                       .setPositiveButton("OK" ,
                               new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialogInterface , int i) {

                                       for(int j=0;j<strings.length;j++){
                                           if (a) {
                                               list[0]=list[0]+","+strings[j];
                                           }
                                       }
                                       binding.btnMutiChoose.setText(list[0]);
                                   }
                               })
                       .setNegativeButton("Cancel" , new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface , int i) {

                           }
                       }).create();
               alertDialog.show();
           }
       });
       binding.btnMutiChoose2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String[] strings1= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
               String[] list1=new String[1];
               boolean[] booleans={true,false,false,false,false,false,false};
               boolean a = true;
               AlertDialog alertDialog= new AlertDialog.Builder(MainActivity.this)
                       .setTitle("choose tags")
                       .setMultiChoiceItems(strings1 , booleans , new DialogInterface.OnMultiChoiceClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface , int i , boolean b) {
                               if(b){
                                   boolean a=b;
                               }
                           }

                       })
                       .setPositiveButton("OK" ,
                               new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialogInterface , int i) {

                                       for(int j=0;j<strings1.length;j++){
                                           if (a) {
                                               list1[0]=list1[0]+","+strings1[j];
                                           }
                                       }
                                       binding.btnMutiChoose.setText(list1[0]);
                                   }
                               })
                       .setNegativeButton("Cancel" , new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface , int i) {

                           }
                       }).create();
               alertDialog.show();
           }
       });


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_popup,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_formFile:
                Toast.makeText(getBaseContext(),"From file",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem_fromDefault:
                final String[] strings1 = new String[1];
                String[] s ={"Nexus Tune","Winphone tune","Peep tune","Nokia Tune","Etc"};
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).
                        setSingleChoiceItems(s , 0 , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface , int i) {
//                            Toast.makeText(getContext(),strings[i],Toast.LENGTH_LONG).show();
                                strings1[0] =s[i];
                            }
                        })
                        .setPositiveButton("OK" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface , int i) {
                                Toast.makeText(MainActivity.this,strings1[0],Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface , int i) {
                                Toast.makeText(MainActivity.this,"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                dialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

//    private void OnCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_popup, menu);
//        super.onCreateOptionsMenu(menu);
//    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_popup, menu);
//        return true;
//    }

    private void buttonSelectTime() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm");
                    cal.set(0,0,0,i,i1);
                    binding.tvTextTime.setText(simpleDateFormat.format(cal.getTime()));
            }
        },gio,phut,true);
        timePickerDialog.show();
    }
    private void buttonSelectDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                cal.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                binding.tvTextDate.setText(simpleDateFormat.format(cal.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
}