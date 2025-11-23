package com.madeinfa.vectorc5.service.interfaces;

import com.madeinfa.vectorc5.presentation.DashboardIncidenteResponse;
import com.madeinfa.vectorc5.presentation.dto.IncidenciaDTO;

import java.util.List;

public interface IIncidenciasService {
    public DashboardIncidenteResponse obtenerDashboard();
    public IncidenciaDTO obtenerIncidencia(int id);
    public String publicarIncidencia(IncidenciaDTO dto);
}
