package com.madeinfa.vectorc5.service.business;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.DashboardIncidenteResponse;
import com.madeinfa.vectorc5.presentation.dto.IncidenciaDTO;
import com.madeinfa.vectorc5.presentation.dto.IncidenciaDashboardDTO;
import com.madeinfa.vectorc5.service.interfaces.IAIService;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciaService;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciasService;
import com.madeinfa.vectorc5.service.interfaces.ITecnicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class IncidenciasServiceImpl implements IIncidenciasService {

    @Autowired
    IIncidenciaService incidenciaService;
    @Autowired
    IAIService aiService;
    @Autowired
    ITecnicoService tecnicoService;

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
        List<String> idTecs = aiService.llamarTecnicos();
        List<TecnicoEntity> tecnicos = tecnicoService.getTecnicos();
        tecnicos = tecnicos.stream().filter(item -> {
            AtomicBoolean encontrado = new AtomicBoolean(false);
            idTecs.forEach(id -> {
                if(id.equals(item.getId().toString())) encontrado.set(true);
            });
            return encontrado.get();
        }).toList();


        return incidenciaService.addIncidencia(entity);
    }

    @Override
    public List<String> obtenerTecnicos(int id) {
        IncidenciaEntity incidencia = incidenciaService.getIncidencia(id);
        return incidencia.getTecnicos().stream().map(item -> {
            return String.format("%d %d", item.getNombre(), item.getApellido());
        }).toList();
    }

    @Override
    public String adjuntarTecnicos(int id) {
        return "";
    }


}
