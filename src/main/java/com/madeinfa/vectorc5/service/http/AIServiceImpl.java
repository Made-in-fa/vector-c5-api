package com.madeinfa.vectorc5.service.http;

import com.madeinfa.vectorc5.service.interfaces.IAIService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIServiceImpl implements IAIService {
    @Override
    public List<String> llamarTecnicos() {
        return List.of("0611bdb1-8b9b-443d-a9b4-1040e2e59e13","12bea9af-94f4-41c6-9f32-616ed053bbc3");
    }
}
