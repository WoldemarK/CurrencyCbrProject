package ru.cloudmicro.currencycbrproject.parser;

import ru.cloudmicro.currencycbrproject.domain.CurrencyNominalRate;

import java.util.List;

public interface Parser {
    List<CurrencyNominalRate> parse(String ratesAsString);
}
