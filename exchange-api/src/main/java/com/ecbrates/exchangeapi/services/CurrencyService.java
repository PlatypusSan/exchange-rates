package com.ecbrates.exchangeapi.services;

import com.ecbrates.exchangeapi.dto.ConversionDTO;
import com.ecbrates.exchangeapi.dto.CurrencyDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CurrencyService {

    public List<CurrencyDTO> getAllCurrencies() {//placeholder
        return Stream.of(
                new CurrencyDTO("USD", 1.2),
                new CurrencyDTO("AUD", 2.3)
        ).collect(Collectors.toList());
    }

    public ConversionDTO processConversion(ConversionDTO currencyDTO) {//placeholder
        return new ConversionDTO("11", "22", "AAA", "BBB");
    }
}
