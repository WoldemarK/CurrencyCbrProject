package ru.cloudmicro.currencycbrproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class CurrencyNominalRate {
    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;
}
