package com.madeinfa.vectorc5.service.interfaces;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IIncidenciaService {
    public String addIncidencia(IncidenciaEntity incidencia);
    public String removeIncidencia(int id);
    public IncidenciaEntity getIncidencia(int id);
    public List<IncidenciaEntity> getIncidencias();
    public List<IncidenciaEntity> getIncidenciasPendientes();
    public List<IncidenciaEntity> getIncidenciasEnCurso();
    public List<IncidenciaEntity> getIncidenciasHistoricas();
}
