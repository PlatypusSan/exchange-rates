package com.ecbrates.exchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConversionDTO {

    String valueFrom;
    String valueTo;
    String currencyFrom;
    String currencyTo;
}
