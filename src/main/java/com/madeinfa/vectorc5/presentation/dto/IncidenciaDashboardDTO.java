package com.madeinfa.vectorc5.presentation.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenciaDashboardDTO {
    private int id;
    private String descripcion;
    private String status;
    private List<String> tecnicos;
}
