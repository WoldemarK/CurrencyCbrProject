package ru.cloudmicro.currencycbrproject.exception;

public class CurrencyRateNotFoundException extends RuntimeException{
    public CurrencyRateNotFoundException(String m) {
        super(m);
    }
}
