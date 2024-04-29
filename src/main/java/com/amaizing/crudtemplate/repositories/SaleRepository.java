package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByOrderByIdAsc();
}
