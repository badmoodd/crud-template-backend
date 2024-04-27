package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "trims")
@Getter
@Setter
@NoArgsConstructor
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trim_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "price")
    private BigDecimal price;
}
