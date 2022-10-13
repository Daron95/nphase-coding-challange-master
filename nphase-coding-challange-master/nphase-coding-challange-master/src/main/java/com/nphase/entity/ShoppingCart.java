package com.nphase.entity;

import java.util.List;

public class ShoppingCart {
    private  int percentage;
    private final List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public List<Product> getProducts() {
        return products;
    }
}
