package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Manufacturer;
import com.amaizing.crudtemplate.repositories.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/manufacturers")
@AllArgsConstructor
public class ManufacturerController {

    private final ManufacturerRepository repository;

    @GetMapping
    public List<Manufacturer> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Manufacturer create(@RequestBody Manufacturer manufacturer) {
        return repository.save(manufacturer);
    }

    @PostMapping("/{id}")
    public Manufacturer update(@PathVariable("id") Long id, @RequestBody Manufacturer manufacturer) {
        manufacturer.setId(id);
        return repository.save(manufacturer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}