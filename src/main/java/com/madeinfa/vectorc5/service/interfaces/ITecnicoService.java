package com.madeinfa.vectorc5.service.interfaces;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.util.enums.EstadoTecnico;

import java.util.UUID;
import java.util.List;

public interface ITecnicoService {
    public TecnicoEntity getTecnico(UUID id);
    public String addTecnico(TecnicoEntity tecnico);
    public String removeTecnico(UUID id);
    public String modifyTecnico(UUID id, TecnicoEntity tecnico);
    public List<TecnicoEntity> getTecnicos();
    public String cambiarEstado(UUID id, EstadoTecnico estadoTecnico);
}
