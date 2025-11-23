package com.madeinfa.vectorc5.presentation.controller;

import com.madeinfa.vectorc5.presentation.DashboardIncidenteResponse;
import com.madeinfa.vectorc5.presentation.dto.IncidenciaDTO;
import com.madeinfa.vectorc5.service.interfaces.IIncidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/v1/incidencias")
public class ReporteController {

    @Autowired
    IIncidenciasService incidenciasService;

    @GetMapping("/")
    public ResponseEntity<DashboardIncidenteResponse> obtenerDatosDashboard() {
        return ResponseEntity.ok(incidenciasService.obtenerDashboard());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaDTO> obtenerIncidencia(@PathVariable int id){
        return ResponseEntity.ok(incidenciasService.obtenerIncidencia(id));
    }

    @PostMapping("/reporte")
    public ResponseEntity<String> iniciarIncidencia(@RequestParam IncidenciaDTO dto) {
        return ResponseEntity.ok(incidenciasService.publicarIncidencia(dto));
    }

    @PutMapping("/reporte/{id}/tecnicos")
    public ResponseEntity<String> adjuntarTecnicos(@PathVariable int id) {
        return ResponseEntity.ok(incidenciasService.adjuntarTecnicos(id));
    }
}
