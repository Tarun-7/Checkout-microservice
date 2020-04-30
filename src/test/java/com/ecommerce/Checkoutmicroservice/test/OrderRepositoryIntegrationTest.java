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

        Orders orderexpected = new Orders("888",123,"details","12.3","processing", 20.3);
        orderRepository.save(orderexpected);

        Optional<Orders> orderactual = orderRepository.findById("888");

        Assert.assertEquals(orderexpected.getOrderId() , orderactual.get().getOrderId());
        //System.out.println("Test run Successful");
    }
}