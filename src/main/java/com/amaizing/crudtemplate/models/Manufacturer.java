package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "manufacturers")
@Getter
@Setter
@NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

}
