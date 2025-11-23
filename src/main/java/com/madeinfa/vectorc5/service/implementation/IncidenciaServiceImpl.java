package com.madeinfa.vectorc5.service.implementation;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import com.madeinfa.vectorc5.persistence.repository.IncidenciaRepository;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidenciaServiceImpl implements IIncidenciaService {

    @Autowired
    IncidenciaRepository incidenciaRepository;

    @Override
    public String addIncidencia(IncidenciaEntity incidencia) {
        incidenciaRepository.save(incidencia);
        return "Incidencia agregada exitosamente";
    }

    @Override
    public String removeIncidencia(int id) {
        incidenciaRepository.deleteById(id);
        return "";
    }

    @Override
    public IncidenciaEntity getIncidencia(int id) {
        return incidenciaRepository.findById(id).get();
    }

    @Override
    public List<IncidenciaEntity> getIncidencias() {
        return incidenciaRepository.findAll();
    }

    @Override
    public List<IncidenciaEntity> getIncidenciasPendientes() {
        return incidenciaRepository.findAllByEstadoPendiente();
    }

    @Override
    public List<IncidenciaEntity> getIncidenciasEnCurso() {
        return incidenciaRepository.findAllByEstadoAbierta();
    }

    @Override
    public List<IncidenciaEntity> getIncidenciasHistoricas() {
        return incidenciaRepository.findAllByEstadoCerrada();
    }
}
