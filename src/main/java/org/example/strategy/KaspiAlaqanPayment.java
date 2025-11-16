package org.example.strategy;

import org.example.factory.Order;

public class KaspiAlaqanPayment implements Strategy{
    private String palmPrint;
    private int bonus;
    public KaspiAlaqanPayment(String palmPrint) {
        this.palmPrint = palmPrint;
    }
    public boolean isValidPalmPrint() {
        if(palmPrint != null && !palmPrint.isEmpty()) {
            return true;
        }
        return false;
    }
    @Override
    public boolean payment(Order order) {
        double total = order.calculateTotalPrice();
        double bonus = total * 0.03;
        if(!isValidPalmPrint()) {
            System.out.println("Payment failed.Kaspi alaqan doesnt recognized your palm print");
            return false;
        }
        System.out.println("Payment with Kaspi alaqan successful.Money paid: " + total + ".Cashback returned: " + bonus);
        return true;
    }
}
