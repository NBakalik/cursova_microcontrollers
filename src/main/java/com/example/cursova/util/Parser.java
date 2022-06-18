package com.example.cursova.util;

import com.example.cursova.model.Humidity;
import com.example.cursova.model.Light;
import com.example.cursova.model.Temperature;
import com.example.cursova.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class Parser {
    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private HumidityService humidityService;
    @Autowired
    private LightService lightService;
    @Autowired
    private SensorStateService sensorStateService;
    @Autowired
    private SystemStateService systemStateService;

    public void parseTemperature(int value) {
        System.out.println("temp = " + value);
        temperatureService.add(new Temperature(value, LocalDate.now(), LocalTime.now()));
    }

    public void parseHumidity(int value) {
        System.out.println("hum = " + value);
        humidityService.add(new Humidity(value, LocalDate.now(), LocalTime.now()));
    }

    public void parseLight(int value) {
        System.out.println("ldr = " + value);
        lightService.add(new Light(value, LocalDate.now(), LocalTime.now()));
    }

    public void parseSensorState(String name) {
        System.out.println("command = " + name);
        sensorStateService.updateSensorStateByName(name);
    }

    public void parseSystemState(String name) {
        System.out.println("command = " + name);
        systemStateService.updateSystemStateByName(name);
    }
}

