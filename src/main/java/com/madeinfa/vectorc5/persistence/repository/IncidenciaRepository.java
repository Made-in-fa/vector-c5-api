package com.madeinfa.vectorc5.persistence.repository;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidenciaRepository extends JpaRepository<IncidenciaEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM incidencia WHERE estado='ABIERTA'")
    List<IncidenciaEntity> findAllByEstadoAbierta();
    @Query(nativeQuery = true, value = "SELECT * FROM incidencia WHERE estado='PENDIENTE'")
    List<IncidenciaEntity> findAllByEstadoPendiente();
    @Query(nativeQuery = true, value = "SELECT * FROM incidencia WHERE estado='CERRADA'")
    List<IncidenciaEntity> findAllByEstadoCerrada();
}
