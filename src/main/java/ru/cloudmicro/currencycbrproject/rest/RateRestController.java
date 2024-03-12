package ru.cloudmicro.currencycbrproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cloudmicro.currencycbrproject.domain.CurrencyRate;
import ru.cloudmicro.currencycbrproject.service.RateService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}")
public class RateRestController {
    private final RateService rateService;

    @GetMapping("/{charCode}")
    public CurrencyRate getRateByCharCode(@PathVariable String charCode) {
        return rateService.getRateByCharCode(charCode);
    }
}
