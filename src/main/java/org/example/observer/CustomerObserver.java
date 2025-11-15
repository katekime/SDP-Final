package org.example.observer;

import org.example.factory.Order;
import org.example.model.MenuItem;

public class CustomerObserver implements Observer {
    @Override
    public void update(Order order) {
        String status = order.getStatus();
        switch (status) {
            case "Created":
                System.out.println("Customer: Your order #" + order.getOrderId() + " has been created.Waiting for a payment");
                break;
            case "Paid":
                System.out.println("Customer: Payment of order #"  + order.getOrderId() + " was successful!");
                break;
            case "Failed":
                System.out.println("Customer: Payment of order #"  + order.getOrderId() + " has been failed!Please try again");
                break;
            case "Preparing":
                System.out.println("Customer: Order #" +  order.getOrderId() + " is preparing!Items of preparing are: ");
                for(MenuItem item : order.getItems()) {
                    System.out.println(" " + item.getName() + " in progress of preparing");
                }
                break;
            case "Ready":
                System.out.println("Customer: Your order #" +  order.getOrderId() + " is ready!");
                break;
            case "Served":
                System.out.println("Customer: Your order #" +  order.getOrderId() + " is served.Enjoy your meal!");
        }
    }

}
