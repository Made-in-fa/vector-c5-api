package com.madeinfa.vectorc5.configuration.app;

import com.madeinfa.vectorc5.persistence.entity.IncidenciaEntity;
import com.madeinfa.vectorc5.persistence.entity.TecnicoEntity;
import com.madeinfa.vectorc5.persistence.repository.IncidenciaRepository;
import com.madeinfa.vectorc5.persistence.repository.TecnicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TecnicoRepository tecnicoRepository;
    private final IncidenciaRepository incidenciaRepository;

    public DataInitializer(TecnicoRepository tecnicoRepository, IncidenciaRepository incidenciaRepository) {
        this.tecnicoRepository = tecnicoRepository;
        this.incidenciaRepository = incidenciaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear técnicos de ejemplo
        TecnicoEntity t1 = new TecnicoEntity();
        t1.setNombre("Juan");
        t1.setApellido("Pérez");
        t1.setEspecialidad("Redes");
        t1.setEstado(null);

        TecnicoEntity t2 = new TecnicoEntity();
        t2.setNombre("María");
        t2.setApellido("García");
        t2.setEspecialidad("Sistemas");
        t2.setEstado(null);

        tecnicoRepository.saveAll(Arrays.asList(t1, t2));

        // Crear incidencias de ejemplo y asignar técnicos
        IncidenciaEntity i1 = new IncidenciaEntity();
        i1.setDescripcion("Corte de fibra en sector centro");
        i1.setSolucion(null);
        i1.setHoraInicio(LocalDateTime.now());
        i1.setSistema("Acceso");
        i1.setGabinete("G1");
        i1.setComunica(null);
        i1.setDesc_inicial(null);


        IncidenciaEntity i2 = new IncidenciaEntity();
        i2.setDescripcion("Interferencia en enlace inalámbrico");
        i2.setSolucion(null);
        i2.setHoraInicio(LocalDateTime.now().minusHours(2));
        i2.setSistema("Radio");
        i2.setGabinete("G2");
        i2.setComunica(null);
        i2.setDesc_inicial(null);

        t1.setIncidencias(List.of(i1,i2));
        t1.setIncidencias(List.of(i1));

        incidenciaRepository.saveAll(Arrays.asList(i1, i2));

        System.out.println("Datos de ejemplo insertados: técnicos e incidencias.");
    }
}
