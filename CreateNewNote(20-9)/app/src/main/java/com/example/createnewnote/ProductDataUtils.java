package com.example.createnewnote;

import java.util.ArrayList;
import java.util.List;

public class ProductDataUtils {
   public static List<Product> getProducts(){
   Product product1= new Product(1,"Work");
   Product product2= new Product(2,"Friend");
   Product product3= new Product(3,"Family");
   List<Product> list= new ArrayList<Product>();
   list.add(product1);
   list.add(product2);
   list.add(product3);
   return list;
   }

}
