package com.madeinfa.vectorc5.service.implementation;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.persistence.repository.TecnicoRepository;
import com.madeinfa.vectorc5.service.interfaces.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TecnicoServiceImpl implements ITecnicoService{

    @Autowired
    TecnicoRepository tecnicoRepository;

    @Override
    public TecnicoEntity getTecnico(UUID id) {
        return tecnicoRepository.findById(id).get();
    }

    @Override
    public String addTecnico(TecnicoEntity tecnico) {
        tecnicoRepository.save(tecnico);
        return "Tecnico agregado exitosamente";
    }

    @Override
    public String removeTecnico(UUID id) {
        tecnicoRepository.deleteById(id);
        return "";
    }

    @Override
    public String modifyTecnico(UUID id, TecnicoEntity tecnico) {
        tecnico.setId(id);
        tecnicoRepository.save(tecnico);
        return "";
    }

    @Override
    public List<TecnicoEntity> getTecnicos(){
        return tecnicoRepository.findAll();
    }


}