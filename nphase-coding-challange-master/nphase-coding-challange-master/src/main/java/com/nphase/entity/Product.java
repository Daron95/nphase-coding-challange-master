package com.nphase.entity;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private BigDecimal pricePerUnit;
    private final int quantity;
    private final String category;


    public Product(String name, BigDecimal pricePerUnit, int quantity, String category) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal bigDecimal) {  // to configure the amount of the item
        this.pricePerUnit = bigDecimal;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }
}
