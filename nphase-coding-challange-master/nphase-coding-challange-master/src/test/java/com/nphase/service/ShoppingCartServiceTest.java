package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;


public class ShoppingCartServiceTest {
    private final ShoppingCartService service = new ShoppingCartService();


    // Buying 3 items of the product within the same category
    @Test
    public void calculatesPriceSameCategory() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, "drinks"),
                new Product("Cheese", BigDecimal.valueOf(8), 2, "food")
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(31.84));
    }

    //Buying same product more than 3 times
    @Test
    public void calculatesPriceSameProduct() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 4, "drinks")
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(19.08));
    }

    //Buying same product less than 3 times
    @Test
    public void calculatesPriceSameProduct2() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks")
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(10.6));
    }

    //Buying 3 products within one category and buy one of the product more than 3 times
    @Test
    public void calculatesPriceSameProductCategory() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 5, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 1, "drinks"),
                new Product("GreenTea", BigDecimal.valueOf(6), 1, "drinks")
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(30.015));
    }

}