package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.ServiceWorkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceWorkTypeRepository extends JpaRepository<ServiceWorkType, Long> {

    List<ServiceWorkType> findAllByOrderByIdAsc();
}
