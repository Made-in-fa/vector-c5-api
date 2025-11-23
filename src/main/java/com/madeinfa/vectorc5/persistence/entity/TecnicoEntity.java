package com.madeinfa.vectorc5.persistence.entity;

import com.madeinfa.vectorc5.util.enums.EstadoTecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tecnico")
public class TecnicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nombre;
    private String contrasenia;
    private String apellido;
    private EstadoTecnico estado = EstadoTecnico.NO_DISPONIBLE;
    private String especialidad;

    // Relación uno a muchos con IncidenciaEntity
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<IncidenciaEntity> incidencias;
}
