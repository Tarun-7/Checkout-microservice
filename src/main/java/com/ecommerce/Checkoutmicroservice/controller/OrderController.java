/**
 @author   Prashant, Tauseef, Tarun Rainy
 @version  1.5
 */
package com.ecommerce.Checkoutmicroservice.controller;


import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/Order-service")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Lists out all the orders in the Database
    @RequestMapping("/Allorders")
    public List<Orders> getAllOrders() {

        return orderService.findAllOrders();
    }

    // Gets Order by 'id' passed
    @RequestMapping("/orders/{id}")
    public Optional<Orders> getOrderbyId(@PathVariable String id) {

        return orderService.findById(id);
    }

    // Gets Orders Specific to User
    @RequestMapping("/Userorders/{id}")
    public List<Orders> getOrderbyUserId(@PathVariable int id) {

        return orderService.findUserIdOrders(id);
    }


    // ADDS new Order To the Database
    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public void addItem(@RequestBody Orders orderItem) {
        orderService.addOrderItem(orderItem);

    }

    // Updates the status of the Order
    @RequestMapping(method = RequestMethod.PUT, value = "/order-status")
    public void updateOrder(@RequestBody Orders orderItem) {
        orderService.updateOrder(orderItem);
    }

}
