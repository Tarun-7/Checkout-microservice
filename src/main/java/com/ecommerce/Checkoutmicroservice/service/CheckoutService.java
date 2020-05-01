/**
 @author   Prashant, Tauseef, Tarun, Rainy
 @version  1.5
 */
package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.model.Cart;
import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Shipment;

import java.util.List;

public interface CheckoutService {

    public void addShipment(Orders orders);

    public List<Shipment> findAllOrders();

    public void createNewOrder(Cart cart);

    public Orders getlastOrder();
}
