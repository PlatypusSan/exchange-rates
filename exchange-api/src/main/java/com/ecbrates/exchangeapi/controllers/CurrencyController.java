package com.ecbrates.exchangeapi.controllers;

import com.ecbrates.exchangeapi.dto.ConversionDTO;
import com.ecbrates.exchangeapi.dto.CurrencyDTO;
import com.ecbrates.exchangeapi.services.CurrencyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CurrencyController {

    CurrencyService currencyService;
    @GetMapping("/currencies")
    public List<CurrencyDTO> getCurrencies() {
        log.info("at getCurrencies");
        return currencyService.getAllCurrencies();
    }

    @PostMapping("/currency")
    public ConversionDTO processConversion(@RequestBody ConversionDTO conversion) {
        log.info("at processConversion" + conversion.toString());
        return currencyService.processConversion(conversion);
    }
}
