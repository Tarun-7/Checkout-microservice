package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Shipment;

import java.util.List;

public interface CheckoutService {

    public void addShipment(Shipment shipmentItem, int cartTotal);

    public List<Shipment> findAllOrders();
}
