package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Trim;
import com.amaizing.crudtemplate.repositories.TrimRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/trims")
@AllArgsConstructor
public class TrimController {

    private final TrimRepository repository;

    @GetMapping
    public List<Trim> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Trim create(@RequestBody Trim trim) {
        return repository.save(trim);
    }

    @PostMapping("/{id}")
    public Trim update(@PathVariable("id") Long id, @RequestBody Trim trim) {
        trim.setId(id);
        return repository.save(trim);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}