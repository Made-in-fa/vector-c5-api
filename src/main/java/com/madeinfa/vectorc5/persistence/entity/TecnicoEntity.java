package com.madeinfa.vectorc5.persistence.entity;

import com.madeinfa.vectorc5.util.enums.EstadoIncidencia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nombre;
    String apellido;
//     estado;
    String especialidad;

}
