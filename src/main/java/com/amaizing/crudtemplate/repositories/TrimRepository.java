package com.amaizing.crudtemplate.repositories;

import com.amaizing.crudtemplate.models.Trim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrimRepository extends JpaRepository<Trim, Long> {
}
