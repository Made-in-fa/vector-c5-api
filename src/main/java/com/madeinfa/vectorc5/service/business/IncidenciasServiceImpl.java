package com.madeinfa.vectorc5.service.business;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import com.madeinfa.vectorc5.presentation.DashboardIncidenteResponse;
import com.madeinfa.vectorc5.presentation.dto.IncidenciaDTO;
import com.madeinfa.vectorc5.presentation.dto.IncidenciaDashboardDTO;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciaService;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciasServiceImpl implements IIncidenciasService {

    @Autowired
    IIncidenciaService incidenciaService;

    @Override
    public DashboardIncidenteResponse obtenerDashboard() {
        List<IncidenciaDashboardDTO> pendientes = incidenciaService.getIncidenciasPendientes().stream().map(item -> {
            return IncidenciaDashboardDTO.builder()
                    .id(item.getId())
                    .descripcion(item.getDescripcion())
                    .status(item.getEstado().toString())
                    .build();
        }).toList();;


        List<IncidenciaDashboardDTO> enCurso = incidenciaService.getIncidenciasEnCurso().stream().map(item -> {
            return IncidenciaDashboardDTO.builder()
                    .id(item.getId())
                    .descripcion(item.getDescripcion())
                    .status(item.getEstado().toString())
                    .build();
        }).toList();;


        List<IncidenciaDashboardDTO> realizados = incidenciaService.getIncidenciasHistoricas().stream().map(item -> {
            return IncidenciaDashboardDTO.builder()
                    .id(item.getId())
                    .descripcion(item.getDescripcion())
                    .status(item.getEstado().toString())
                    .build();
        }).toList();;

        return DashboardIncidenteResponse.builder()
                .enCurso(enCurso)
                .completados(realizados)
                .pendientes(pendientes)
                .build();
    }

    @Override
    public IncidenciaDTO obtenerIncidencia(int id) {
        IncidenciaEntity entity=incidenciaService.getIncidencia(id);
        return IncidenciaDTO.builder()
                .id(entity.getId())
                .comunica(entity.getComunica())
                .coordenadas(entity.getCoordenadas())
                .desc_inicial(entity.getDesc_inicial())
                .descripcion(entity.getDescripcion())
                .estado(entity.getEstado())
                .gabinete(entity.getGabinete())
                .horaInicio(entity.getHoraInicio())
                .sistema(entity.getSistema())
                .solucion(entity.getSolucion())
                .susbsistema(entity.getSusbsistema())
                .build();
    }

    @Override
    public String publicarIncidencia(IncidenciaDTO dto) {
        ModelMapper mapper = new ModelMapper();
        IncidenciaEntity entity = mapper.map(dto, IncidenciaEntity.class);
        return incidenciaService.addIncidencia(entity);
    }


}
