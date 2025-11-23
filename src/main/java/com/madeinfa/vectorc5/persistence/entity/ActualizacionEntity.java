package com.madeinfa.vectorc5.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import java.util.List;


@Entity
@Table(name = "actualizacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActualizacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    List<TecnicoEntity> tecnicos;

    LocalDateTime fechaHora;
    String descripcion;
}
