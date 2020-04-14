package com.ecommerce.Checkoutmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    int userId;
    String name;
    String email;
    String dob;
    String phone;

    public Users() {

    }

    public Users(int userId, String name, String email, String dob, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
