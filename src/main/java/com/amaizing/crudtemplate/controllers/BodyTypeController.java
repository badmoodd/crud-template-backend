package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.BodyType;
import com.amaizing.crudtemplate.repositories.BodyTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables/body_types")
@AllArgsConstructor
public class BodyTypeController {

    private final BodyTypeRepository repository;

    @GetMapping
    public List<BodyType> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public BodyType create(@RequestBody BodyType bodyType) {
        return repository.save(bodyType);
    }

    @PutMapping("/{id}")
    public BodyType update(@PathVariable("id") Long id, @RequestBody BodyType bodyType) {
        bodyType.setId(id);
        return repository.save(bodyType);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}
