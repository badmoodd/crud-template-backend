package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {
}
