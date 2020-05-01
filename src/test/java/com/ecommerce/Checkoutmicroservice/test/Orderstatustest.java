/**
 @author  Tarun
 @version  1.3
 */
package com.ecommerce.Checkoutmicroservice.test;

import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Orderstatustest {


    @Autowired
    OrderService orderService;

    @Test
    public void testorderstatus() {


        // Creating a new Order Request
        Orders orderactual = new Orders("123",123,"details","12.3","processing", 20.3);
        //Optional<Orders> orderactual = orderService.findById("123");
        System.out.println(orderactual.getStatus());
        String orderexpected = Orders.SUCCESS;

        //Updating the order status
        orderService.updateOrder(orderactual);

        //Verifying whether Order Status got updated
        Assert.assertEquals(orderexpected , orderactual.getStatus());
    }
}
