package org.example.factory;

public class InsideOrderFactory extends OrderFactory {
    @Override
    public Order createOrder() {
        Order order = new Order(generateOrderId());
        System.out.println("Created Inside-restaurant Order #" + order.getOrderId());
        return order;
    }
}
