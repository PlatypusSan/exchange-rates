package com.ecbrates.exchangeapi.controllers;

import com.ecbrates.exchangeapi.dto.HistoryDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {

    @GetMapping("history")
    public List<HistoryDto> getHistory(){
        return Stream.of(
                new HistoryDto("11.11.2011", "EUR to AUD", "1.5", "link.com"),
                new HistoryDto("22.22.2011", "USD to AUD", "1.7", "link2.com"),
                new HistoryDto("10.10.2011", "USD to EUR", "2.5", "link3.com")
        ).collect(Collectors.toList());
    }
}
