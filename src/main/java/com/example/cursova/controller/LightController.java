package com.example.cursova.controller;

import com.example.cursova.model.Light;
import com.example.cursova.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/light")
public class LightController {

    @Autowired
    private LightService lightService;

    @GetMapping()
    public List<Light> getAllLight() {
        return lightService.getAllLight();
    }

    @PostMapping()
    public void add(@RequestBody Light light) {
        lightService.add(light);
    }
}


