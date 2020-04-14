package com.ecommerce.Checkoutmicroservice.model;

public class Shipment {

    private int charges;
    private String time;
//    private String orderId;

    public Shipment(){

    }

    public Shipment(int charges, String time) {
        this.charges = charges;
        this.time = time;
    }

    public int getCharges() {
        return charges;
    }



    public void setCharges(int charges) {
        this.charges = charges;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
