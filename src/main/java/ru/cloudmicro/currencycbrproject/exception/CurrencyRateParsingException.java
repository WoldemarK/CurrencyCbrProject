package ru.cloudmicro.currencycbrproject.exception;

public class CurrencyRateParsingException extends RuntimeException{
    public CurrencyRateParsingException(Exception ex) {
        super(ex);
    }
}
