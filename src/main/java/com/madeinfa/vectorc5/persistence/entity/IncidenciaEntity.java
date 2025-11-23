package com.madeinfa.vectorc5.persistence.entity;

import com.madeinfa.vectorc5.util.enums.EstadoIncidencia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geolatte.geom.Point;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaEntity {
    @Id
    private int id;
    private String descripcion;
    private String solucion;
    private EstadoIncidencia estado = EstadoIncidencia.ABIERTA;
    private String tecnica;
    private String sistema;
    private String susbsistema;
    private String gabinete;


    @Column(name="hora_inicio")
    private LocalDateTime horaInicio;

    @Column(name="hora_fin")

    private LocalDateTime horaFin;
    private Point coordenadas;
    private String comunica;
    private String desc_inicial;

}
