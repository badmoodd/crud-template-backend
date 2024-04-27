package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.ServiceCenter;
import com.amaizing.crudtemplate.repositories.ServiceCenterRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tables/service_centers")
@AllArgsConstructor
public class ServiceCenterController {

    private final ServiceCenterRepository repository;

    @GetMapping
    public List<ServiceCenter> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ServiceCenter create(@RequestBody ServiceCenter serviceCenter) {
        return repository.save(serviceCenter);
    }

    @PutMapping("/{id}")
    public ServiceCenter update(@PathVariable("id") Long id, @RequestBody ServiceCenter serviceCenter) {
        serviceCenter.setId(id);
        return repository.save(serviceCenter);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}