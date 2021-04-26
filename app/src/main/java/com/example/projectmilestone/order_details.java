package com.example.projectmilestone;

public class order_details {


    int id,price;
    String order_type,toppings;

    public order_details(int id, int price, String order_type, String toppings) {
        this.id = id;
        this.price = price;
        this.order_type = order_type;
        this.toppings = toppings;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }




}

