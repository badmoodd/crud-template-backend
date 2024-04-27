package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.BodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
}
