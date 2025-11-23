package com.madeinfa.vectorc5.persistence.repository;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TecnicoRepository extends JpaRepository<UUID, TecnicoEntity>{
}
