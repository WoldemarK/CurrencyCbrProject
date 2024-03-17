package ru.cloudmicro.currencycbrproject.cbrclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cbrclient",
        url = "${cbr.uri}",
        configuration = FeignConfig.class)
public interface CbrClient {
    @GetMapping
    String getRatesByCbr();
}
