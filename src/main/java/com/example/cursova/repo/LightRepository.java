package com.example.cursova.repo;

import com.example.cursova.model.Light;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends CrudRepository<Light, Integer> {
}
