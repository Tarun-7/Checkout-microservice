package com.ecommerce.Checkoutmicroservice.service;


import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderserviceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> findAllOrders() {
        List<Orders> orderslist = new ArrayList<>();
        orderRepository.findAll()
                .forEach(orderslist::add);
        return orderslist;
    }

    @Override
    public Optional<Orders> findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addOrderItem(Orders orderItem) {
        orderItem.setStatus("PROCESSING");
        orderRepository.save(orderItem);
    }

    @Override
    public List<Orders> findUserIdOrders(int id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public void updateOrder(Orders orderItem) {
        orderItem.setStatus("SUCCESS");
        orderRepository.save(orderItem);
    }
}

