package com.madeinfa.vectorc5.util.mapper;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.dto.TecnicoDTO;
import org.modelmapper.ModelMapper;

public class TecnicoMapper {
    private TecnicoMapper(){}

    private static final ModelMapper mapper = new ModelMapper();

    public static TecnicoEntity toEntity(TecnicoDTO dto){
        return  mapper.map(dto, TecnicoEntity.class);
    }

    public static TecnicoDTO toDTO(TecnicoEntity entity){
        return mapper.map(entity, TecnicoDTO.class);
    }
}
