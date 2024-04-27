package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
}
