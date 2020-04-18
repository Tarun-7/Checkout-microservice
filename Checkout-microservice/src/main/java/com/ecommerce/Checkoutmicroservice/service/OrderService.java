package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.model.Orders;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    public List<Orders> findAllOrders();
    public Optional<Orders> findById(String id);
    public void addOrderItem(Orders orderItem);
    public List<Orders> findUserIdOrders(int id);
    public void updateOrder(Orders orderItem);
}
