package com.example.cursova.repo;

import com.example.cursova.model.Temperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
}
