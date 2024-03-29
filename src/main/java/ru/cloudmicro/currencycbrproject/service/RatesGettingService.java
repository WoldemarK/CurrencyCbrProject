package ru.cloudmicro.currencycbrproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.cloudmicro.currencycbrproject.cbrclient.CbrClient;
import ru.cloudmicro.currencycbrproject.domain.CurrencyNominalRate;
import ru.cloudmicro.currencycbrproject.domain.CurrencyRate;
import ru.cloudmicro.currencycbrproject.parser.Parser;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatesGettingService {
    private final CbrClient cbrClient;
    private final Parser parser;

    @Cacheable("rates")
    public List<CurrencyRate> getCurrencyRates(String date) {
        log.info("Getting rates from CBR.");
        String xmlCbr = cbrClient.getRatesByCbr();
        List<CurrencyNominalRate> nominalRateList = parser.parse(xmlCbr);
        return nominalRateList.stream()
                .map(n ->
                        new CurrencyRate(n.getCharCode(),
                                Double.parseDouble(n.getValue())
                                        / Double.parseDouble(n.getNominal())))
                .collect(Collectors.toList());
    }
}
