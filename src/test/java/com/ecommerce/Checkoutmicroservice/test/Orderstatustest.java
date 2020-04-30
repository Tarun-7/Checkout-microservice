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

        String orderexpected = "SUCCESS";

        Orders orderactual = new Orders("123",123,"details","12.3","processing", 20.3);
        //Optional<Orders> orderactual = orderService.findById("123");
        System.out.println(orderactual.getStatus());
        orderService.updateOrder(orderactual);

        Assert.assertEquals(orderexpected , orderactual.getStatus());
        //System.out.println("Test run Successful");
    }
}
