package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.StrategyPattern.PremiumShipping;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.StandardShipping;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.Strategy;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.StrategyContext;
import com.ecommerce.Checkoutmicroservice.model.Shipment;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public void addShipment(Shipment shipmentItem, int cartTotal) {

        if(cartTotal > 1000) {
            StrategyContext strategyContext = new StrategyContext(new PremiumShipping());
            System.out.println("Premium Shipping Charges" + strategyContext.executeStrategy(cartTotal));
        }
        else {
            StrategyContext strategyContext = new StrategyContext(new StandardShipping());
            System.out.println("Standard Shipping Charges" + strategyContext.executeStrategy(cartTotal));
        }


        //ShipmentRepository.save(shipmentItem);
    }
}
