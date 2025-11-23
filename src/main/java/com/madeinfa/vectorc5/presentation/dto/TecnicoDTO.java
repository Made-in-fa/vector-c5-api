package com.madeinfa.vectorc5.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import com.madeinfa.vectorc5.util.enums.EstadoTecnico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TecnicoDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    private String nombre;
    private String contrasenia;
    private String apellido;
    private EstadoTecnico estado = EstadoTecnico.NO_DISPONIBLE;
    private String especialidad;
    private List<IncidenciaEntity> incidencias;
}
