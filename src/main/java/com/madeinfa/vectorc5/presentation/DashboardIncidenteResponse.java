package com.madeinfa.vectorc5.presentation;

import com.madeinfa.vectorc5.presentation.dto.IncidenciaDashboardDTO;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardIncidenteResponse {
    List<IncidenciaDashboardDTO> pendientes;
    List<IncidenciaDashboardDTO> enCurso;
    List<IncidenciaDashboardDTO> completados;
}
