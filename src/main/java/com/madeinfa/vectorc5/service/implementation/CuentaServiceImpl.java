package com.madeinfa.vectorc5.service.implementation;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.dto.TecnicoDTO;
import com.madeinfa.vectorc5.service.interfaces.ICuentaService;
import com.madeinfa.vectorc5.service.interfaces.ITecnicoService;
import com.madeinfa.vectorc5.util.mapper.TecnicoMapper;

import java.util.UUID;

public class CuentaServiceImpl implements ICuentaService {

    ITecnicoService tecnicoService;

    @Override
    public String crearCuenta(TecnicoDTO tecnico) {
        TecnicoEntity entity= TecnicoMapper.toEntity(tecnico);
        tecnicoService.addTecnico(entity);
        return "Cuenta creada";
    }

    @Override
    public String eliminarCuenta(UUID id) {
        tecnicoService.removeTecnico(id);
        return "Cuenta eliminada";
    }

    @Override
    public TecnicoDTO modificarCuenta(UUID id, TecnicoDTO tecnico) {
        TecnicoEntity entity= TecnicoMapper.toEntity(tecnico);
        tecnicoService.modifyTecnico(id, entity);
        return null;
    }

    @Override
    public UUID obtenerCuenta(UUID id, String contrasenia) {
        if(tecnicoService.getTecnico(id).getContrasenia().equals(contrasenia)){
            return id;
        }
        return null;
    }
}
