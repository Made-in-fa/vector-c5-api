package com.madeinfa.vectorc5.service.interfaces;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.dto.TecnicoDTO;

import java.util.UUID;

public interface ICuentaService {
    public String crearCuenta(TecnicoDTO tecnico);
    public String eliminarCuenta(UUID id);
    public TecnicoDTO modificarCuenta(UUID id, TecnicoDTO tecnico);
    public UUID obtenerCuenta(UUID id,  String contrasenia);
}
