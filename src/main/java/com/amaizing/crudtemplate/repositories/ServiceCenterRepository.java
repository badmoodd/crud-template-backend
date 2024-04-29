package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {

    List<ServiceCenter> findAllByOrderByIdAsc();
}
