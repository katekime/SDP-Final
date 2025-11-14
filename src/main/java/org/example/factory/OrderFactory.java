package org.example.factory;

public abstract class OrderFactory {
    private static int orderCounter = 100;

    public abstract Order createOrder();

    protected int generateOrderId() {
        return orderCounter++;
    }
}
