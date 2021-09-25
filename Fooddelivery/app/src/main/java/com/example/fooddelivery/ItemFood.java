package com.example.fooddelivery;

import android.graphics.drawable.Icon;

public class ItemFood {
    String nameFood;
    String price;
    boolean Favo;
    boolean Item;
    boolean Star;
    boolean Star2;
    boolean Star3;
    boolean Star4;
    boolean Star5;
    boolean Add;

    public ItemFood(String nameFood, String price, boolean favo, boolean item, boolean star, boolean star2, boolean star3, boolean star4, boolean star5, boolean add) {
        this.nameFood = nameFood;
        this.price = price;
        Favo = favo;
        Item = item;
        Star = star;
        Star2 = star2;
        Star3 = star3;
        Star4 = star4;
        Star5 = star5;
        Add = add;
    }

    public boolean isStar2() {
        return Star2;
    }

    public void setStar2(boolean star2) {
        Star2 = star2;
    }

    public boolean isStar3() {
        return Star3;
    }

    public void setStar3(boolean star3) {
        Star3 = star3;
    }

    public boolean isStar4() {
        return Star4;
    }

    public void setStar4(boolean star4) {
        Star4 = star4;
    }

    public boolean isStar5() {
        return Star5;
    }

    public void setStar5(boolean star5) {
        Star5 = star5;
    }

    public ItemFood(String nameFood, String price) {
        this.nameFood = nameFood;
        this.price = price;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public boolean isFavo() {
        return Favo;
    }

    public void setFavo(boolean favo) {
        Favo = favo;
    }

    public boolean isItem() {
        return Item;
    }

    public void setItem(boolean item) {
        Item = item;
    }

    public boolean isStar() {
        return Star;
    }

    public void setStar(boolean star) {
        Star = star;
    }
    public boolean isAdd() {
        return Add;
    }

    public void setAdd(boolean add) {
        Add = add;
    }
}
