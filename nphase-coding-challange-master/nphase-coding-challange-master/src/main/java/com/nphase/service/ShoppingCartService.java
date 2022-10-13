package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import java.math.BigDecimal;
import java.util.*;

public class ShoppingCartService {

    private final Map<String, Integer> categories = new HashMap<>();

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {

        shoppingCart.setPercentage(10);  // configure percentage to 10 %
        List<Product> products = shoppingCart.getProducts();

        getRepeatedCategories(products);
        calculateProductPrice(shoppingCart);

        return shoppingCart.getProducts()
                .stream()
                .map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void getRepeatedCategories(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (categories.containsKey(products.get(i).getCategory())) {
                categories.put(products.get(i).getCategory(), categories.get(products.get(i).getCategory()) + 1);
            } else
                categories.put(products.get(i).getCategory(), 0);
        }
    }

    //buying more than 3 items of the product within the same category
    // OR!!   more than 3 items of the same product
    //  ==>>  discount 10 %
    public void calculateProductPrice(ShoppingCart shoppingCart) {
        for (Product product : shoppingCart.getProducts()) {
            if (categories.get(product.getCategory()) > 0) {
                product.setPricePerUnit(product.getPricePerUnit().subtract(product.getPricePerUnit().divide(BigDecimal.valueOf((shoppingCart.getPercentage())))));
            }
            if (product.getQuantity() > 3) {
                product.setPricePerUnit(product.getPricePerUnit().subtract(product.getPricePerUnit().divide(BigDecimal.valueOf((shoppingCart.getPercentage())))));

            }
        }
    }
}
