package org.example.observer;
import org.example.factory.*;
import org.example.model.MenuItem;

public class KitcherObserver implements Observer {
    @Override
    public void update(Order order) {
        String status = order.getStatus();

        switch (status) {
            case "Paid":
                System.out.println("Kitchen: New order #" + order.getOrderId() + " has been paid. Start cooking immediately!");
                break;
            case "Failed":
                System.out.println("Kitchen: Payment failed for order #" + order.getOrderId() + ". Hold preparation.");
                break;
            case "Created":
                System.out.println("Kitchen: New order #" + order.getOrderId() + " has been created! Prepare the following items:");
                for(MenuItem item : order.getItems()) {
                    System.out.println(item.getName() + ": " + item.prepare());
                }
                break;
            case "Preparing":
                System.out.println("Kitchen: Order #" + order.getOrderId() + " is being prepared:");
                for(MenuItem item : order.getItems()) {
                System.out.println(" Cooking " + item.getName());
                }
                break;
            case "Ready":
                System.out.println("Kitchen: Order #" + order.getOrderId() + " is ready!");
                break;
        }
    }
}
