package com.example.cursova.controller;

import com.example.cursova.model.SystemState;
import com.example.cursova.service.SystemStateService;
import com.example.cursova.util.Serial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemState")
public class SystemStateController {

    @Autowired
    private SystemStateService systemStateService;
    @Autowired
    private Serial serial;

    @PostMapping("/{id}")
    public void updateSystemState(@PathVariable int id) {
        serial.updateSystemState(id);
        systemStateService.updateSystemStateById(id);
    }

    @GetMapping()
    public List<SystemState> getAllSystemStates() {
        return systemStateService.getAllSystemStates();
    }
}


