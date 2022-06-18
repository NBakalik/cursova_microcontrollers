package com.example.cursova.repo;

import com.example.cursova.model.SystemState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemStateRepository extends CrudRepository<SystemState, Integer> {
}
