package ru.cloudmicro.currencycbrproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.cloudmicro.currencycbrproject.domain.CurrencyRate;
import ru.cloudmicro.currencycbrproject.exception.CurrencyRateNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class RateService {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final RatesGettingService ratesGettingService;

    public CurrencyRate getRateByCharCode(String charCode) {
        LocalDateTime time = LocalDateTime.now();
        String date = dtf.format(time);
        log.info("Getting rate for {}.", charCode);
        return ratesGettingService.getCurrencyRates(date).stream()
                .filter(rate -> rate.getCharCode().equals(charCode))
                .findFirst()
                .orElseThrow(() ->
                        new CurrencyRateNotFoundException("Currency Rate not found. Currency:"
                                + charCode + ", date:" + date));
    }
}