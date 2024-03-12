package ru.cloudmicro.currencycbrproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class CurrencyRate {
    String charCode;
    Double value;
}
