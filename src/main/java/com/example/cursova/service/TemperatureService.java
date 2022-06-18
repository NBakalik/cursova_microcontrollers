package com.example.cursova.service;

import com.example.cursova.model.Temperature;
import com.example.cursova.repo.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class TemperatureService {
    @Autowired
    private TemperatureRepository temperatureRepository;

    public List<Temperature> getAllTemperature() {
        return (List<Temperature>) temperatureRepository.findAll();
    }

    public void add(Temperature temperature) {
        temperatureRepository.save(temperature);
    }
}
