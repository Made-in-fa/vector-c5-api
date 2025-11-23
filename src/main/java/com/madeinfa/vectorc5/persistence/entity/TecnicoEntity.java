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
    private String apellido;
    private String contrasenia;
    private EstadoTecnico estado = EstadoTecnico.NO_DISPONIBLE;
    private String especialidad;
    private String tokenFB;

    // Relación uno a muchos con IncidenciaEntity
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "incidencia_tecnico",
            joinColumns = @JoinColumn(name = "incidencia_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    ) private List<IncidenciaEntity> incidencias;
}
