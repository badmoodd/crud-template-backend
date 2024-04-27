package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Manufacturer;
import com.amaizing.crudtemplate.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tables/sales")
@AllArgsConstructor
public class SaleController {

    private final ManufacturerRepository repository;

    @GetMapping
    public List<Manufacturer> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Manufacturer create(@RequestBody Manufacturer manufacturer) {
        return repository.save(manufacturer);
    }

    @PutMapping("/{id}")
    public Manufacturer update(@PathVariable("id") Long id, @RequestBody Manufacturer manufacturer) {
        manufacturer.setId(id);
        return repository.save(manufacturer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}