package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.model.Shipment;

public interface CheckoutService {

    public void addShipment(Shipment shipmentItem, int cartTotal);
}
