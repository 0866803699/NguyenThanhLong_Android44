package com.example.createnewnote;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
    private LayoutInflater flater;
    private List<Product> list;
    private int listItemLayoutResource;
    private int textViewItemNameId;

    public AdapterProduct(Activity context, int listItemLayoutResource,
                          int textViewItemNameId,
                          List<Product> list) {
        this.flater = context.getLayoutInflater();
        this.list = list;
        this.listItemLayoutResource = listItemLayoutResource;
        this.textViewItemNameId = textViewItemNameId;
    }



    @Override
    public int getCount() {
        if(this.list == null)  {
            return 0;
        }
        return this.list.size();

    }

    @Override
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        Product product = (Product) this.getItem(i);
        return product.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Product product = (Product) getItem(i);


        View view1 = this.flater.inflate(this.listItemLayoutResource, null,true);


        TextView textViewItemName = (TextView) view1.findViewById(this.textViewItemNameId);
        textViewItemName.setText(product.getName());


        return view1;
    }
}
