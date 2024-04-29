package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> findAllByOrderByIdAsc();
}
