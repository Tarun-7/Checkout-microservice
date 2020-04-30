package com.ecommerce.Checkoutmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

    public String SUCCESS = "SUCCESS";
    public String FAILED = "FAILED";
    public String PROCESSING = "PROCESSING";

    @Id
    private String orderId;
    private Integer userId;
    private String orderDetails;
    private String orderTime;
    private String status;
    private Double orderTotal;

    public Orders() {
    }

    public Orders(String orderId, Integer userId, String orderDetails, String orderTime, String status, Double orderTotal) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDetails = orderDetails;
        this.orderTime = orderTime;
        this.status = status;
        this.orderTotal = orderTotal;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }


}
