package com.ecommerce.Checkoutmicroservice.repository;


import com.ecommerce.Checkoutmicroservice.model.Orders;
import com.ecommerce.Checkoutmicroservice.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, String> {

    public List<Orders> findByUserId(int userId);

    //public Orders findByID(String orderId);
}
