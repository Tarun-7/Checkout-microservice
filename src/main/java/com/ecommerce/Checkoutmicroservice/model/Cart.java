/**
 @author   Prashant, Tauseef, Tarun ,Rainy
 @version  1.5
 */
package com.ecommerce.Checkoutmicroservice.model;

public class Cart {

    int quantity;
    int cartId;
    int productId;
    int userId;
    double totalCost;

    public Cart(){

    }

    public Cart(int quantity, int cartId, int productId, int userId, double totalCost) {
        this.quantity = quantity;
        this.cartId = cartId;
        this.productId = productId;
        this.userId = userId;
        this.totalCost = totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartId() {
        
        return cartId;
    }

    public void setCartID(int cartId) {

        this.cartId = cartId;
    }

    public int getProductId() {

        return productId;
    }

    public void setProductId(int productId) {

        this.productId = productId;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public double getTotalCost() {

        return totalCost;
    }

    public void setTotalCost(double totalCost) {

        this.totalCost = totalCost;
    }
}
