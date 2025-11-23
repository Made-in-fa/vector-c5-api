
package com.madeinfa.vectorc5.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madeinfa.vectorc5.util.enums.EstadoIncidencia;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.geolatte.geom.Point;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "incidencia")
public class IncidenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String solucion;
    private String descripcion;
    private String elemento;
    @Enumerated(EnumType.STRING)
    private EstadoIncidencia estado = EstadoIncidencia.ABIERTA;
    private String sistema;
    private String susbsistema;
    private String gabinete;


    @Column(name="hora_inicio")
    private LocalDateTime horaInicio;

    private Point coordenadas;
    private String comunica;
    private String desc_inicial;

    @JsonIgnore
    @ManyToMany(mappedBy = "incidencias", fetch = FetchType.LAZY)
    private Set<TecnicoEntity> tecnicos = new HashSet<>();

    @OneToMany
    private List<ActualizacionEntity> actualizaciones;


}

