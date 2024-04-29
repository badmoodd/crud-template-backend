package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findAllByOrderByIdAsc();
}
