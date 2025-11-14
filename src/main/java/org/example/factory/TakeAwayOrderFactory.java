package org.example.factory;

public class TakeAwayOrderFactory extends OrderFactory {
    @Override
    public Order createOrder() {
        Order order = new Order(generateOrderId());
        System.out.println("Created Take-away Order #" + order.getOrderId());
        return order;
    }
}
