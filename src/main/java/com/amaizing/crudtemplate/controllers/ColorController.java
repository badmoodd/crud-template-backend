package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Color;
import com.amaizing.crudtemplate.repositories.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/tables/colors")
@AllArgsConstructor
public class ColorController {

    private final ColorRepository repository;

    @GetMapping
    public List<Color> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Color create(@RequestBody Color color) {
        return repository.save(color);
    }

    @PutMapping("/{id}")
    public Color update(@PathVariable("id") Long id, @RequestBody Color color) {
        color.setId(id);
        return repository.save(color);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}