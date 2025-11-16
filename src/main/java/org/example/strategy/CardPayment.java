package org.example.strategy;

import org.example.factory.Order;

public class CardPayment implements Strategy{
    private String cardNumber;
    private String expiryMonth;
    private String cvv;

    public CardPayment(String cardNumber, String expiryMonth, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.cvv = cvv;
    }
    public boolean validateCard() {
        if(cardNumber.length() < 16) {
            System.out.println("Invalid card number");
            return false;
        }
        if(cvv.length() != 3 ) {
            System.out.println("Invalid cvv");
            return false;
        }
        if(!expiryMonth.matches("\\d{2}/\\d{2}")) {
            System.out.println("Invalid expiry date");
            return false;
        }
        return true;
    }
    @Override
    public boolean payment(Order order) {
        double total = order.calculateTotalPrice();
        double commission = total * 0.01;
        double finalAmount = total + commission;
        if(!validateCard()) {
            return false;
        }
        System.out.println("Payment successful.Commission: " + commission + ".Total charged: " + finalAmount);
        return true;
    }
}
