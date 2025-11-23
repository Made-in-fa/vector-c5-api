package com.madeinfa.vectorc5.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Table(name = "medidas_tiempos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedidasTiemposEntity {
    @Column(name="inicio_reparacion")
    private LocalDateTime inicioReparacion;

    @Column(name="fin_reparacion")
    private LocalDateTime finReparacion ;

    private LocalDateTime llegada;
    private LocalDateTime disponibilidad;
    private int demora;
    private int trayecto;
    private int espera;
    private int intervencion;
    private int indiponibilidad;
}
