package com.example.cursova.controller;

import com.example.cursova.model.SensorState;
import com.example.cursova.service.SensorStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class SensorStateController {

    @Autowired
    private SensorStateService sensorStateService;

    @PostMapping("/{id}")
    public void updateSensorState(@PathVariable int id) {
        sensorStateService.updateSensorStateById(id);
    }

    @GetMapping()
    public List<SensorState> getAllSensorStates() {
        return sensorStateService.getAllSensorState();
    }
}


