package com.example.cursova.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int value;
    private LocalDate date;
    private LocalTime time;

    public Temperature(int value, LocalDate date, LocalTime time) {
        this.value = value;
        this.date = date;
        this.time = time;
    }
}
