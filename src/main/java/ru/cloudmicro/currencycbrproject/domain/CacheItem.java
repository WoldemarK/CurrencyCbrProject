package ru.cloudmicro.currencycbrproject.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.Objects;


@Value
@AllArgsConstructor
public class CacheItem {

    String date;
    List<CurrencyRate> currencyRateList;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CacheItem cacheItem = (CacheItem) o;
        return date.equals(cacheItem.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
