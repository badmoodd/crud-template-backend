package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.CarModel;
import com.amaizing.crudtemplate.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/car_models")
@AllArgsConstructor
public class CarModelController {

    private final CarModelRepository repository;

    @GetMapping
    public List<CarModel> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public CarModel create(@RequestBody CarModel carModel) {
        return repository.save(carModel);
    }

    @PostMapping("/{id}")
    public CarModel update(@PathVariable("id") Long id, @RequestBody CarModel carModel) {
        carModel.setId(id);
        return repository.save(carModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}