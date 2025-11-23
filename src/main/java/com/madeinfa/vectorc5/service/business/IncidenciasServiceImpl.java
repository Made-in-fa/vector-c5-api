package com.madeinfa.vectorc5.service.business;

import com.madeinfa.vectorc5.presentation.DashboardIncidenteResponse;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciaService;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenciasServiceImpl implements IIncidenciasService {

    @Autowired
    IIncidenciaService incidenciaService;

    @Override
    public DashboardIncidenteResponse obtenerDashboard() {

    }
}
