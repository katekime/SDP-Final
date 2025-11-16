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
        this.status = "Created";
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
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
    public void setStrategy(Strategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void pay() {
        if(paymentStrategy == null) {
            throw new IllegalArgumentException("There is not payment Strategy");
        }
        boolean success = paymentStrategy.payment(this);
        if(success) {
            this.status = "Paid";
        }
        else {
            this.status = "Failed";
        }
        System.out.println("Order #" + orderId + ".Status: " + status);
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        for(int i = 0; i< observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(this);
        }
    }
}
