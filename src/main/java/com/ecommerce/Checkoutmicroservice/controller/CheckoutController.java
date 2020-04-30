package com.ecommerce.Checkoutmicroservice.controller;

import com.ecommerce.Checkoutmicroservice.model.Cart;
import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Shipment;
import com.ecommerce.Checkoutmicroservice.service.CheckoutService;
import com.ecommerce.Checkoutmicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/checkout-microservice")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private RestTemplate restTemplate;

    // Creating a new order
    @RequestMapping(method = RequestMethod.POST, value = "/CreateOrder")
    public void createOrder( ) {
        Cart cart = new Cart();
        cart.setQuantity(2);
        cart.setCartID(999);
        cart.setProductId(163);
        cart.setUserId(777);
        cart.setTotalCost(2000);
        checkoutService.createNewOrder(cart);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/CreateOrder", produces = "application/json")
    public Orders getlastOrder( ) {
        return checkoutService.getlastOrder();
    }

        // ADDS new Shipment request To the Database
    @RequestMapping(method = RequestMethod.POST, value = "/ShipmentCharges")
    public void getshipment(/*@RequestBody Shipment shipmentItem*/) {
        Orders orders = restTemplate.getForObject("http://order-service/checkout-microservice/CreateOrder", Orders.class);
        checkoutService.addShipment(orders);

    }

    // Lists out all the orders in the Database
    @RequestMapping("/Shipments")
    public List<Shipment> getAllOrders() {
        return checkoutService.findAllOrders();
    }

}
