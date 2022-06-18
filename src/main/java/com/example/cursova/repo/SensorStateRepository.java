package com.example.cursova.repo;

import com.example.cursova.model.SensorState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorStateRepository extends CrudRepository<SensorState, Integer> {
}
