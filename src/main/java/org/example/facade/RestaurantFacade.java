package org.example.facade;

import org.example.abstractFactory.CuisineFactory;
import org.example.abstractFactory.JapaneseCuisineFactory;
import org.example.abstractFactory.KazakhCuisineFactory;
import org.example.adapter.CurrencyPaymentAdapter;
import org.example.decorator.LemonDecorator;
import org.example.decorator.SorpaDecorator;
import org.example.decorator.WasabiDecorator;
import org.example.factory.InsideOrderFactory;
import org.example.factory.Order;
import org.example.factory.OrderFactory;
import org.example.factory.TakeAwayOrderFactory;
import org.example.model.MenuItem;
import org.example.observer.CustomerObserver;
import org.example.observer.KitcherObserver;
import org.example.strategy.*;
import org.example.visitor.ServeFeeVisitor;

public class RestaurantFacade {
    private OrderFactory orderFactory;
    private CuisineFactory cuisineFactory;
    public Order createOrder(String orderType) {
        if(orderType.equalsIgnoreCase("inside")) {
            orderFactory = new InsideOrderFactory();
        } else if(orderType.equalsIgnoreCase("takeaway")) {
            orderFactory = new TakeAwayOrderFactory();
        } else {
            throw new IllegalArgumentException("Invalid order type. Use 'inside' or 'takeaway'");
        }
        Order order = orderFactory.createOrder();
        order.addObserver(new CustomerObserver());
        order.addObserver(new KitcherObserver());
        return order;
    }
    public void addCuisineSet(Order order, String cuisineType) {
        if(cuisineType.equalsIgnoreCase("japanese")) {
            cuisineFactory = new JapaneseCuisineFactory();
            System.out.println("Adding Japanese cuisine Set...");
        } else if(cuisineType.equalsIgnoreCase("kazakh")) {
            cuisineFactory = new KazakhCuisineFactory();
            System.out.println("Adding Kazakh cuisine set...");
        } else {
            throw new IllegalArgumentException("Invalid cuisine type. Use 'japanese' or 'kazakh'");
        }
        order.addItem(cuisineFactory.createAppetizer());
        order.addItem(cuisineFactory.createMainCourse());
        order.addItem(cuisineFactory.createDrink());
        order.addItem(cuisineFactory.createDessert());
        System.out.println("Full cuisine set added to order #" + order.getOrderId());
    }
    public MenuItem addCustomItem(Order order, String cuisineType, String itemType, String decorator) {
        if(cuisineType.equalsIgnoreCase("japanese")) {
            cuisineFactory = new JapaneseCuisineFactory();
        } else {
            cuisineFactory = new KazakhCuisineFactory();
        }
        MenuItem item = null;
        switch(itemType.toLowerCase()) {
            case "appetizer":
                item = cuisineFactory.createAppetizer();
                break;
            case "maincourse":
                item = cuisineFactory.createMainCourse();
                break;
            case "drink":
                item = cuisineFactory.createDrink();
                break;
            case "dessert":
                item = cuisineFactory.createDessert();
                break;
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
        if(decorator != null && !decorator.isEmpty()) {
            item = applyDecorator(item, decorator);
        }
        order.addItem(item);
        return item;
    }
    private MenuItem applyDecorator(MenuItem item, String decoratorInput) {
        if (decoratorInput == null || decoratorInput.isEmpty()) {
            return item;
        }
        String lowerInput = decoratorInput.toLowerCase();

        if (lowerInput.equals("wasabi")) {
            return new WasabiDecorator(item, 5);
        } else if (lowerInput.equals("lemon")) {
            return new LemonDecorator(item, "Fresh lemon slices");
        } else if (lowerInput.equals("sorpa")) {
            return new SorpaDecorator(item, "Traditional meat broth");
        } else {
            return new LemonDecorator(item, decoratorInput);
        }
    }
    public double calculateServiceFee(Order order) {
        ServeFeeVisitor feeVisitor = new ServeFeeVisitor();
        System.out.println("Calculating service fee, 10% per item");
        order.acceptVisitor(feeVisitor);
        double totalFee = feeVisitor.getTotalFee();
        System.out.println("Total service fee: $" + String.format("%.2f", totalFee));
        return totalFee;
    }
    public void processPayment(Order order, String paymentMethod, String currency, boolean includeServiceFee) {
        Strategy payment = null;
        double baseTotal = order.calculateTotalPrice();
        double serviceFee = 0;

        if(includeServiceFee) {
            serviceFee = calculateServiceFee(order);
        }
        double finalTotal = baseTotal + serviceFee;
        switch(paymentMethod.toLowerCase()) {
            case "card":
                payment = new CardPayment("1234567890123456", "12/27", "123");
                System.out.println("Selected payment method: Credit Card");
                break;
            case "cash":
                payment = new CashPayment(finalTotal + 10); // даем на $10 больше
                System.out.println("Selected payment method: Cash");
                break;
            case "kaspi":
                payment = new KaspiAlaqanPayment("valid-palm-print-12345");
                System.out.println("Selected payment method: Kaspi Alaqan");
                break;
            default:
                throw new IllegalArgumentException("Invalid payment method");
        }
        System.out.println("Base amount: $" + String.format("%.2f", baseTotal));
        if(includeServiceFee) {
            System.out.println("Service fee: $" + String.format("%.2f", serviceFee));
        }
        System.out.println("Final amount: $" + String.format("%.2f", finalTotal));

        if(currency != null && !currency.equalsIgnoreCase("USD")) {
            payment = new CurrencyPaymentAdapter(payment, currency);
        }
        order.setStrategy(payment);
        order.pay();
    }
    public void processPayment(Order order, String paymentMethod, String currency) {
        processPayment(order, paymentMethod, currency, false);
    }
    public void updateOrderStatus(Order order, String newStatus) {
        System.out.println("Updating order status");
        order.setStatus(newStatus);
    }
    public void displayOrderSummary(Order order) {
        System.out.println("Order summary");
        System.out.println("Order ID: #" + order.getOrderId());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Items: ");

        for(MenuItem item : order.getItems()) {
            System.out.println("- " + item.getName() + " (" + item.getCategory() + ")");
            System.out.println("Price: $" + String.format("%.2f", item.getPrice()));
            System.out.println("Description: " + item.getDescription());
        }
        System.out.println("Subtotal: $" + String.format("%.2f", order.calculateTotalPrice()));
    }
}
