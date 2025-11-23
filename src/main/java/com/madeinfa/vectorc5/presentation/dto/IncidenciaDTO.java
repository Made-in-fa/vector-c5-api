package com.madeinfa.vectorc5.presentation.dto;

import com.madeinfa.vectorc5.util.enums.EstadoIncidencia;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.geolatte.geom.Point;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncidenciaDTO {
    private int id;
    private String solucion;
    private String elemento;
    private String descripcion;
    private EstadoIncidencia estado = EstadoIncidencia.ABIERTA;
    private String sistema;
    private String susbsistema;
    private String gabinete;
    private LocalDateTime horaInicio = LocalDateTime.now();
    private Point coordenadas;
    private String comunica;
    private String desc_inicial;
}
