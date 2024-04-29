package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Engine;
import com.amaizing.crudtemplate.repositories.EngineRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tables/engines")
@AllArgsConstructor
public class EngineController {

    private final EngineRepository repository;

    @GetMapping
    public List<Engine> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Engine create(@RequestBody Engine engine) {
        return repository.save(engine);
    }

    @PostMapping("/{id}")
    public Engine update(@PathVariable("id") Long id, @RequestBody Engine engine) {
        engine.setId(id);
        return repository.save(engine);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}