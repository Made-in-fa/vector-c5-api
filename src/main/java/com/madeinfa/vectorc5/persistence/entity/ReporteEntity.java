package com.madeinfa.vectorc5.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int semana;
    private LocalDate fecha;
    private String turno;
    private String ubicacion;

    @OneToOne
    private IncidenciaEntity incidencia;

}
