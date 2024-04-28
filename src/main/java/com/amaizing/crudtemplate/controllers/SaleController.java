package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.Sale;
import com.amaizing.crudtemplate.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tables/sales")
@AllArgsConstructor
public class SaleController {

    private final SaleRepository repository;

    @GetMapping
    public List<Sale> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return repository.save(sale);
    }

    @PutMapping("/{id}")
    public Sale update(@PathVariable("id") Long id, @RequestBody Sale sale) {
        sale.setId(id);
        return repository.save(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }


}