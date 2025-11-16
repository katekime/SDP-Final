package org.example.adapter;
import org.example.factory.Order;
import org.example.strategy.Strategy;

public class CurrencyPaymentAdapter implements Strategy {
    private Strategy originalPayment;
    private String currency;
    private CurrencyConverter currencyConverter;

    public CurrencyPaymentAdapter(Strategy originalPayment, String currency) {
        this.originalPayment = originalPayment;
        this.currency = currency.toUpperCase();
        ExternalExchangeApi externalApi = new ExternalExchangeApi();
        this.currencyConverter = new CurrencyExchangeAdapter(externalApi);
    }
    @Override
    public boolean payment(Order order) {
        double totalInUSD = order.calculateTotalPrice();
        double totalInSelectedCurrency = currencyConverter.convertFromUSD(currency, totalInUSD);
        String currencySymbol = currencyConverter.getCurrencySymbol(currency);
        String currencyName = currencyConverter.getCurrencyName(currency);

        System.out.println("Currency Conversion (Adapter Pattern)");
        System.out.println("Using External Exchange API through Adapter");
        System.out.println("Currency: " + currencyName);
        System.out.println("Original amount: $" + String.format("%.2f", totalInUSD) + " USD");
        System.out.println("Converted amount: " + currencySymbol + String.format("%.2f", totalInSelectedCurrency) + " " + currency);

        if(!currency.equals("USD")) {
            double rate = currencyConverter.convertFromUSD(currency, 1.0);
            System.out.println("Exchange rate: 1 USD = " + String.format("%.2f", rate) + " " + currency);
        }
        boolean result = originalPayment.payment(order);

        if(result) {
            System.out.println("\n✓ Payment in " + currency + " processed successfully!");
            System.out.println("  Amount paid: " + currencySymbol + String.format("%.2f", totalInSelectedCurrency) + " " + currency);
            System.out.println("  Equivalent: $" + String.format("%.2f", totalInUSD) + " USD");
        }
        return result;
    }
}
