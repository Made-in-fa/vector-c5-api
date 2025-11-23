package com.madeinfa.vectorc5.presentation.dto;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ActualizacionDTO {
    private int id;
    List<String> tecnicos;
    LocalDateTime fechaHora;
    String descripcion;
}
