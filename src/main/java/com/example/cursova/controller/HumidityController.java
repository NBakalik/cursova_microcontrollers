package com.example.cursova.controller;

import com.example.cursova.model.Humidity;
import com.example.cursova.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/humidity")
public class HumidityController {

    @Autowired
    private HumidityService humidityService;

    @GetMapping()
    public List<Humidity> getAllHumidity() {
        return humidityService.getAllHumidity();
    }

    @PostMapping()
    public void add(@RequestBody Humidity humidity) {
        humidityService.add(humidity);
    }
}


