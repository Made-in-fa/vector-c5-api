package com.madeinfa.vectorc5.presentation.controller;

import com.madeinfa.vectorc5.presentation.DashboardIncidenteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/v1/incidencias")
public class IncidenciasController {


    @GetMapping
    public ResponseEntity<DashboardIncidenteResponse> obtenerDatosDashboard() {

    }
}
