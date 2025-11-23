package com.madeinfa.vectorc5.persistence.repository;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

public interface IncidenciaRepository extends JpaRepository<IncidenciaEntity, Integer> {
}
