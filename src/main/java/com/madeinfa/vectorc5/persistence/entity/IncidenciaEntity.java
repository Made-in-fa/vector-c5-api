package com.madeinfa.vectorc5.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaEntity {
    @Id
    int id;
    String descripcion;
    String solucion;
    String estado;
    @Column(name="hora_inicio")
    LocalDateTime horaInicio;
    @Column(name="hora_fin")
    LocalDateTime horaFin;
    private Point coordenadas;

}
