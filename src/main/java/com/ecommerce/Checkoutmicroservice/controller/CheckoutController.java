package com.ecommerce.Checkoutmicroservice.controller;

import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Shipment;
import com.ecommerce.Checkoutmicroservice.service.CheckoutService;
import com.ecommerce.Checkoutmicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/checkout-microservice")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    // ADDS new Shipment request To the Database
    @RequestMapping(method = RequestMethod.POST, value = "/ShipmentCharges")
    public void getshipment(@RequestBody Shipment shipmentItem) { // Should be changed to cart object while linking
        int cartTotal = 1000;
        checkoutService.addShipment(shipmentItem, cartTotal);    // remove shipment item in arguments

    }

    // Lists out all the orders in the Database
    @RequestMapping("/Shipments")
    public List<Shipment> getAllOrders() {
        return checkoutService.findAllOrders();
    }

}
