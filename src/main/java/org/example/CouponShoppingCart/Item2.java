package org.example.CouponShoppingCart;

public class Item2 extends Product {

    Item2(String name, double price, ProductType type){
        super(name, price, type);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
