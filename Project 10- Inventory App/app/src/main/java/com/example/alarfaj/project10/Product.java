package com.example.alarfaj.project10;

/**
 * Created by Alarfaj on 10/13/17.
 */

public class Product {

    private String name;
    private int price;
    private int quantity;
    private String supplier;
    private final String image;

    public Product (String name, int price, int quantity,String supplier,String image)
     {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.supplier=supplier;
        this.image=image;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getname() {
        return name;
    }
    public int getprice() {
        return price;
    }
    public String getsupplier() {
        return supplier;
    }
    public String getImage() {
        return image;
    }
}
