package com.madeinfa.vectorc5.service.interfaces;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.dto.TecnicoDTO;
import com.madeinfa.vectorc5.util.enums.EstadoTecnico;

import java.util.UUID;

public interface ICuentaService {
    public String crearCuenta(TecnicoDTO tecnico);
    public String eliminarCuenta(UUID id);
    public TecnicoDTO modificarCuenta(UUID id, TecnicoDTO tecnico);
    public TecnicoEntity obtenerCuenta(UUID id, String contrasenia);
    public String updateEstado(UUID id, EstadoTecnico nuevoEstado);
    public String guardarToken(UUID uuid, String token);

    TecnicoEntity iniciarSesion(UUID id, String contra);
}
