package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoubleController {
    @GetMapping("/double")
    public Double doubling(@RequestParam(value = "number", defaultValue = "0") String number) {
        return new Double(Integer.parseInt(number) * 2);
    }
}
