package com.example.cursova.service;

import com.example.cursova.model.Humidity;
import com.example.cursova.repo.HumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class HumidityService {
    @Autowired
    private HumidityRepository humidityRepository;

    public List<Humidity> getAllHumidity() {
        return (List<Humidity>) humidityRepository.findAll();
    }

    public void add(Humidity humidity) {
        humidityRepository.save(humidity);
    }
}
