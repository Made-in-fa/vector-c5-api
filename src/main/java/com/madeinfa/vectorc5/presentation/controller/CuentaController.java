package com.madeinfa.vectorc5.presentation.controller;

import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.presentation.dto.TecnicoDTO;
import com.madeinfa.vectorc5.service.interfaces.ICuentaService;
import com.madeinfa.vectorc5.util.enums.EstadoTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/cuenta")
public class CuentaController {

    @Autowired
    ICuentaService service;

    @PostMapping("")
    public ResponseEntity<String> crearCuenta(TecnicoDTO tecnico){
        service.crearCuenta(tecnico);
        return ResponseEntity.ok("Cuenta Creada");
    }

    @GetMapping("/")
    public ResponseEntity<TecnicoEntity> iniciarSesion(String id, String contra) {
        UUID uuid=UUID.fromString(id);
        return ResponseEntity.ok(service.obtenerCuenta(uuid, contra));
    }
    @DeleteMapping("")
    public ResponseEntity<String> deleteCuenta(UUID id){
        service.eliminarCuenta(id);
        return ResponseEntity.ok("Cuenta eliminada");
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<String> actualizarEstado(@PathVariable String id, @RequestParam EstadoTecnico estado) {
        UUID uuid=UUID.fromString(id);
        service.updateEstado(uuid, estado);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}/fbtoken")
    public ResponseEntity<String> tokenNotificaciones(@PathVariable UUID id, @RequestParam String token) {
        return ResponseEntity.ok(service.guardarToken(id, token))   ;
    }

}
