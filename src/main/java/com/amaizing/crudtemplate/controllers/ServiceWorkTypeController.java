package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.ServiceWorkType;
import com.amaizing.crudtemplate.repositories.ServiceWorkTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/service_work_types")
@AllArgsConstructor
public class ServiceWorkTypeController {

    private final ServiceWorkTypeRepository repository;

    @GetMapping
    public List<ServiceWorkType> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public ServiceWorkType create(@RequestBody ServiceWorkType serviceWorkType) {
        return repository.save(serviceWorkType);
    }

    @PostMapping("/{id}")
    public ServiceWorkType update(@PathVariable("id") Long id, @RequestBody ServiceWorkType serviceWorkType) {
        serviceWorkType.setId(id);
        return repository.save(serviceWorkType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}