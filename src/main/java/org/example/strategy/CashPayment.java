package org.example.strategy;

import org.example.factory.Order;

public class CashPayment implements Strategy{
    private double cashProvided;
    public CashPayment(double cashProvided) {
        this.cashProvided = cashProvided;
    }
    @Override
    public boolean payment(Order order) {
        double total = order.calculateTotalPrice();
        if(cashProvided < total) {
            System.out.println("Not enough money.Required money: " + total + ".Your money: " + cashProvided + ".Need to add: " + (total - cashProvided));
            return false;
        }
        double paid = cashProvided - total;
        System.out.println("Payment successful.Money to return: " + paid + ".Thank you!");
        return true;
    }
}
