package org.example.adapter;

public interface CurrencyConverter {
    double convertFromUSD(String toCurrency, double amountInUSD);
    double convertToUSD(String fromCurrency, double amount);
    String getCurrencyName(String currency);
    String getCurrencySymbol(String currency);
}
