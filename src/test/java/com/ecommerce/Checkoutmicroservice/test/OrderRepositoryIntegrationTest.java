/**
 @author  Tarun
 @version  1.3
 */
package com.ecommerce.Checkoutmicroservice.test;

import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryIntegrationTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testorderindb() {

        //Creating a Order Request and saving to Database
        Orders orderexpected = new Orders("888",123,"details","12.3","processing", 20.3);
        orderRepository.save(orderexpected);

        //Retreiving Value from Database
        Optional<Orders> orderactual = orderRepository.findById("888");

        //Comparing both values
        Assert.assertEquals(orderexpected.getOrderId() , orderactual.get().getOrderId());
        //System.out.println("Test run Successful");
    }
}