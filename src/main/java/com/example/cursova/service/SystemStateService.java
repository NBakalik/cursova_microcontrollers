package com.example.cursova.service;

import com.example.cursova.model.SystemState;
import com.example.cursova.repo.SystemStateRepository;
import com.example.cursova.util.Serial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStateService {
    @Autowired
    private SystemStateRepository systemStateRepository;

    private int currentActiveId = 1;

    public List<SystemState> getAllSystemStates() {
        return (List<SystemState>) systemStateRepository.findAll();
    }

    public void updateSystemStateById(Integer id) {
        if (currentActiveId != id) {
            SystemState systemState = getById(id);
            SystemState systemStateOld = getById(currentActiveId);
            currentActiveId = id;
            systemState.setState(!systemState.isState());
            systemStateOld.setState(!systemStateOld.isState());
            systemStateRepository.save(systemState);
            systemStateRepository.save(systemStateOld);
        }
    }

    public void updateSystemStateByName(String systemStateName) {
        int id = getIdBySystemStateName(systemStateName);
        updateSystemStateById(id);
    }

    public SystemState getById(Integer id) {
        return systemStateRepository.findById(id).orElse(null);
    }

    private int getIdBySystemStateName(String systemState) {
        for (SystemStates systemStates : SystemStates.values()) {
            if (systemStates.systemStateName.equals(systemState)) {
                return systemStates.id;
            }
        }
        return -1;
    }

    private enum SystemStates {
        ACTIVE("ac", 1), SLEEP("sl", 2), SHUTDOWN("sh", 3);

        SystemStates(String systemStateName, int id) {
            this.systemStateName = systemStateName;
            this.id = id;
        }

        private final String systemStateName;
        private final int id;
    }
}
