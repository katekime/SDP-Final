package org.example.adapter;

public class ExternalExchangeApi {
    public double getRate(String currencyCode) {
        switch (currencyCode.toUpperCase()) {
            case "USD":
                return 1.0;
            case "KZT":
                return 523.04;
            case "JPY":
                return 152.15;
            case "RUB":
                return 81.25;
            default:
                throw new IllegalArgumentException("Unknown currency: " + currencyCode);
        }
    }
    public String fullCurrencyName(String code) {
        switch (code.toUpperCase()) {
            case "USD": return "US Dollar";
            case "KZT": return "Kazakhstani Tenge";
            case "JPY": return "Japanese Yen";
            case "RUB": return "Russian Ruble";
            default: return "Unknown";
        }
    }
    public String symbol(String code) {
        switch (code.toUpperCase()) {
            case "USD": return "$";
            case "KZT": return "₸";
            case "JPY": return "¥";
            case "RUB": return "₽";
            default: return "";
        }
    }
}
