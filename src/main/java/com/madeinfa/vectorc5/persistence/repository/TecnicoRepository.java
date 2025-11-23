package com.madeinfa.vectorc5.persistence.repository;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.util.enums.EstadoTecnico;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface TecnicoRepository extends JpaRepository<TecnicoEntity, UUID>{
    @Modifying
    @Transactional
    @Query("UPDATE TecnicoEntity entity SET entity.estado = :newValue WHERE entity.id = :id")
    void updateEstado(@Param("newValue") EstadoTecnico newValue, @Param("id") UUID id);
}
