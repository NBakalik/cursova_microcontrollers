package com.example.cursova.service;

import com.example.cursova.model.SensorState;
import com.example.cursova.repo.SensorStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorStateService {
    @Autowired
    private SensorStateRepository sensorStateRepository;

    public List<SensorState> getAllSensorState() {
        return (List<SensorState>) sensorStateRepository.findAll();
    }

    public void updateSensorStateById(Integer id) {
        SensorState sensorState = getById(id);
        sensorState.setState(!sensorState.isState());
        sensorStateRepository.save(sensorState);
    }

    public void updateSensorStateByName(String sensorName) {
        int id = getIdBySensorName(sensorName);
        SensorState sensorState = getById(id);
        sensorState.setState(!sensorState.isState());
        sensorStateRepository.save(sensorState);
    }

    public SensorState getById(Integer id) {
        return sensorStateRepository.findById(id).orElse(null);
    }

    private int getIdBySensorName(String sensor) {
        for (Sensors sensors : Sensors.values()) {
            if (sensors.sensorName.equals(sensor)) {
                return sensors.id;
            }
        }
        return -1;
    }

    private enum Sensors {
        RAIN("ra", 1), FLAME("fl", 2), AIR("ai", 3), GAS("ga", 4),
        LIGHT("li", 5), FAN("fa", 6), AC("ac", 7), BUZZER("bu", 8);

        Sensors(String sensorName, int id) {
            this.sensorName = sensorName;
            this.id = id;
        }

        private final String sensorName;
        private final int id;
    }
}
