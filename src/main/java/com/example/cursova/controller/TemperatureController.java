package com.example.cursova.controller;

import com.example.cursova.model.Temperature;
import com.example.cursova.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping()
    public List<Temperature> getAllTemperature() {
        return temperatureService.getAllTemperature();
    }

    @PostMapping()
    public void add(@RequestBody Temperature temperature) {
        temperatureService.add(temperature);
    }
}


