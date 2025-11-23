package com.madeinfa.vectorc5.service.implementation;

import com.madeinfa.vectorc5.persistence.entity.ActualizacionEntity;
import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.persistence.repository.ActualizacionRepository;
import com.madeinfa.vectorc5.persistence.repository.TecnicoRepository;
import com.madeinfa.vectorc5.presentation.dto.ActualizacionDTO;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActualizacionService {

    @Autowired
    private ActualizacionRepository actualizacionRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public String agregarActualizacion(ActualizacionDTO dto) {
        ModelMapper mapper=new ModelMapper();
        ActualizacionEntity entity= mapper.map(dto, ActualizacionEntity.class);
        entity.setTecnicos(dto.getTecnicos().stream().map((item)->{
            TecnicoEntity tec= tecnicoRepository.findById(UUID.fromString(item)).get();
            return tec;
        }).toList());
        return "Actualizacion guardada";
    }
}
