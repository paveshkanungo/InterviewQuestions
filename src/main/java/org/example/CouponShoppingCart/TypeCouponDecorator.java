package org.example.CouponShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator {
    Product product;
    int discountPercentage;
    ProductType type;

    static List<ProductType> eligibleItems = new ArrayList<>();
    static{
        eligibleItems.add(ProductType.ELECTRONICS_GOODS);
        eligibleItems.add(ProductType.FURNITURE_GOODS);
    }

    TypeCouponDecorator(Product product, int discountPercentage, ProductType type){
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.type = type;
    }

    @Override
    public double getPrice(){
        double price = product.getPrice();
        if(eligibleItems.contains(type)){
            price = price - (price * discountPercentage)/100;
        }
        return price;
    }
}
