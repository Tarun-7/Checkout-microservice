package com.ecommerce.Checkoutmicroservice.StrategyPattern;

public class StandardShipping implements Strategy {

    @Override
    public double setShippingcharges(double carttotal) {
        return carttotal * 0.05 ;

    }

}
