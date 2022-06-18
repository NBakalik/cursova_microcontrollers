package com.example.cursova.service;

import com.example.cursova.model.Light;
import com.example.cursova.repo.LightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class LightService {
    @Autowired
    private LightRepository lightRepository;

    public List<Light> getAllLight() {
        return (List<Light>) lightRepository.findAll();
    }

    public void add(Light light) {
        lightRepository.save(light);
    }
}
