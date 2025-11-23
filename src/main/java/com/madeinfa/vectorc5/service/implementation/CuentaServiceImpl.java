package com.madeinfa.vectorc5.service.implementation;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.dto.TecnicoDTO;
import com.madeinfa.vectorc5.service.interfaces.ICuentaService;
import com.madeinfa.vectorc5.service.interfaces.ITecnicoService;
import com.madeinfa.vectorc5.util.enums.EstadoTecnico;
import com.madeinfa.vectorc5.util.mapper.TecnicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
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
    public TecnicoEntity obtenerCuenta(UUID id, String contrasenia) {
        System.out.println(id);
        System.out.println(contrasenia);
        TecnicoEntity tecnicoEntity = tecnicoService.getTecnico(id);
        if(tecnicoEntity.getContrasenia().equals(contrasenia)){
            return tecnicoEntity;
        }
        return null;
    }

    @Override
    public String updateEstado(UUID id, EstadoTecnico nuevoEstado) {
        tecnicoService.cambiarEstado(id, nuevoEstado);
        return "";
    }

    @Override
    public String guardarToken(UUID uuid, String token) {
        TecnicoEntity tec = tecnicoService.getTecnico(uuid);
        tec.setTokenFB(token);
        tecnicoService.modifyTecnico(uuid, tec);
        return "Actualizado con exito";
    }

    @Override
    public TecnicoEntity iniciarSesion(UUID id, String contra) {
        TecnicoEntity tecnicoEntity = tecnicoService.getTecnico(id);
        return tecnicoEntity;
    }

}
