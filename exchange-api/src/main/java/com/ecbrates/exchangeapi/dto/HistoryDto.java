package com.ecbrates.exchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoryDto {

    String date;
    String conversion;
    String rate;
    String link;
}
