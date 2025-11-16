package org.example.adapter;

public class CurrencyExchangeAdapter implements CurrencyConverter {
    private final ExternalExchangeApi externalApi;

    public CurrencyExchangeAdapter(ExternalExchangeApi externalApi) {
        this.externalApi = externalApi;
    }
    @Override
    public double convertFromUSD(String toCurrency, double amountInUSD) {
        double rate = externalApi.getRate(toCurrency);
        return amountInUSD * rate;
    }
    @Override
    public double convertToUSD(String fromCurrency, double amount) {
        double rate = externalApi.getRate(fromCurrency);
        return amount / rate;
    }
    @Override
    public String getCurrencyName(String currency) {
        return externalApi.fullCurrencyName(currency);
    }
    @Override
    public String getCurrencySymbol(String currency) {
        return externalApi.symbol(currency);
    }
}
