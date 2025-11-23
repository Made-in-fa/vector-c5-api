package com.madeinfa.vectorc5.presentation.controller;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.service.interfaces.ITecnicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

@RequestMapping("/v1/tecnico")
public class TecnicoController {

    private final ITecnicoService tecnicoService;


    public TecnicoController(ITecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @PostMapping("/tecnico")
    public ResponseEntity addTecnico(TecnicoEntity tecnico){
        return ResponseEntity.ok(tecnicoService.addTecnico(tecnico));
    }

    @GetMapping("/tecnico")
    public TecnicoEntity getTecnico(UUID id){
        return tecnicoService.getTecnico(id);
    }


}
