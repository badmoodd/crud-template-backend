package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "engines")
@Getter
@Setter
@NoArgsConstructor
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id")
    private Long id;

    @Column(name = "engine_model")
    private String engineModel;

    @Column(name = "power")
    private int power;

    @Column(name = "fuel_type")
    private String fuelType;
}