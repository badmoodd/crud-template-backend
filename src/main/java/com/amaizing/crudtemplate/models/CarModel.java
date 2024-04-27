package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car_models")
@Getter
@Setter
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @Column(name = "body_type")
    private String bodyType;
}
