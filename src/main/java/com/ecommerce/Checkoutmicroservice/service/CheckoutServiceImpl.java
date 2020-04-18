package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.StrategyPattern.PremiumShipping;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.StandardShipping;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.Strategy;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.StrategyContext;
import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Shipment;
import com.ecommerce.Checkoutmicroservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Override
    public void addShipment(Shipment shipmentItem, int cartTotal) {

        if (cartTotal > 1000) {
            StrategyContext strategyContext = new StrategyContext(new PremiumShipping());
            System.out.println("Premium Shipping Charges : " + strategyContext.executeStrategy(cartTotal));
        }  else {
            StrategyContext strategyContext = new StrategyContext(new StandardShipping());
            System.out.println("Standard Shipping Charges : " + strategyContext.executeStrategy(cartTotal));
        }

        shipmentRepository.save(shipmentItem);
    }


    @Override
    public List<Shipment> findAllOrders() {
        List<Shipment> shipmentlist = new ArrayList<>();
        shipmentRepository.findAll()
                .forEach(shipmentlist::add);
        return shipmentlist;
    }
}
