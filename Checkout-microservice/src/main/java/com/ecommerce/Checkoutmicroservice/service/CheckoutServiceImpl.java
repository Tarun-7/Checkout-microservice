package com.ecommerce.Checkoutmicroservice.service;

import com.ecommerce.Checkoutmicroservice.StrategyPattern.PremiumShipping;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.StandardShipping;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.Strategy;
import com.ecommerce.Checkoutmicroservice.StrategyPattern.StrategyContext;
import com.ecommerce.Checkoutmicroservice.model.Cart;
import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Shipment;
import com.ecommerce.Checkoutmicroservice.repository.OrderRepository;
import com.ecommerce.Checkoutmicroservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addShipment(Orders orders) {

        Shipment shipmentItem = new Shipment();
        shipmentItem.setOrderId(orders);
        UUID shipmentid = UUID.randomUUID();
        shipmentItem.setShipId(String.valueOf(shipmentid));

        System.out.println("Select ONE of the Shipping Options : ");
        System.out.println(" 1. Premium  2. Standard");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice ==  1) {
            StrategyContext strategyContext = new StrategyContext(new PremiumShipping());
            //System.out.println("Premium Shipping Charges : " + strategyContext.executeStrategy(orders.getOrderTotal()));
            shipmentItem.setCharges(strategyContext.executeStrategy(orders.getOrderTotal()));
            shipmentItem.setTime(" 1-2 Days ");
        }  else {
            StrategyContext strategyContext = new StrategyContext(new StandardShipping());
            //System.out.println("Standard Shipping Charges : " + strategyContext.executeStrategy(orders.getOrderTotal()));
            shipmentItem.setCharges(strategyContext.executeStrategy(orders.getOrderTotal()));
            shipmentItem.setTime(" 4-6 Days ");
        }

        // Adding shippping request to Database.
        shipmentRepository.save(shipmentItem);

        // Printing shipping request details.
        System.out.println("--------SHIPMENT DETAILS-------");
        System.out.println("Order ID : " +shipmentItem.getOrderId());
        System.out.println("Shipment ID :" +shipmentItem.getShipId());
        System.out.println("Shipping Cost :" +shipmentItem.getCharges());
        System.out.println("Shipping Time :" +shipmentItem.getTime());
        System.out.println("--------------------------------");
    }


    @Override
    public List<Shipment> findAllOrders() {
        List<Shipment> shipmentlist = new ArrayList<>();
        shipmentRepository.findAll()
                .forEach(shipmentlist::add);
        return shipmentlist;
    }

    @Override
    public void createNewOrder(Cart cart) {

        Orders orders = new Orders();

        // Setting Order details
        UUID orderid = UUID.randomUUID();
        orders.setOrderId(String.valueOf(orderid));
        orders.setStatus(orders.PROCESSING);
        orders.setOrderTotal(cart.getTotalCost());
        orders.setUserId(cart.getUserId());
        orders.setOrderDetails("Order description");
        orders.setOrderTime(String.valueOf(java.time.Clock.systemUTC().instant()));

        // Saving Order to Database
        orderRepository.save(orders);

        // Printing Order details
        System.out.println("--------SHIPMENT DETAILS-------");
        System.out.println("User ID : "  +orders.getUserId());
        System.out.println("Order ID : "  +orderid );
        System.out.println("Order Time : "  +orders.getOrderTime());
        System.out.println("Order Amount : "  +orders.getOrderTotal());
        System.out.println("Order Status : "  +orders.getStatus());
        System.out.println("--------------------------------");
    }

    @Override
    public Orders getlastOrder() {
        List<Orders> orderslist = new ArrayList<>();
        orderRepository.findAll()
                .forEach(orderslist::add);
        Orders orders = orderslist.get(orderslist.size() - 1);
        return orders;
    }
}
