package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.TableEntry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/v1/tables")
@AllArgsConstructor
public class TableController {

    @GetMapping
    public List<TableEntry> getTables() {
        List<TableEntry> tables = new ArrayList<>();

        tables.add(new TableEntry("Body Types", "/api/v1/tables/body_types", "body_types"));
        tables.add(new TableEntry("Car Models", "/api/v1/tables/car_model", "car_model"));
        tables.add(new TableEntry("Colors", "/api/v1/tables/colors", "colors"));
        tables.add(new TableEntry("Employees", "/api/v1/tables/employees", "employees"));
        tables.add(new TableEntry("Engines", "/api/v1/tables/engines", "engines"));
        tables.add(new TableEntry("Manufacturers", "/api/v1/tables/manufacturers", "manufacturers"));
        tables.add(new TableEntry("Sales", "/api/v1/tables/sales", "sales"));
        tables.add(new TableEntry("Service Centers", "/api/v1/tables/service_centers", "service_centers"));
        tables.add(new TableEntry("Service Work Types", "api/v1/tables/service_work_types", "service_work_types"));
        tables.add(new TableEntry("Trims", "/api/v1/tables/trims", "trims"));

        return tables;
    }


}