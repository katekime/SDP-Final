package org.example.factory;

import org.example.model.MenuItem;
import org.example.observer.Observer;
import org.example.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String status;
    private List<Observer> observers = new ArrayList<>();
    private Strategy paymentStrategy;

    public int orderId; // ###
    public List<MenuItem> items = new ArrayList<>(); // ### for my factory - ulan

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {return orderId;}
    public List<MenuItem> getItems() {return items;}


    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }

        return total;
    }
}
