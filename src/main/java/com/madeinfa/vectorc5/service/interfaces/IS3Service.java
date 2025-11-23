package com.madeinfa.vectorc5.service.interfaces;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public interface IS3Service {
    String crearBucket(String bucketName);
    boolean verificarExistenciaBucket(String bucketName);
    List<String> getAllBuckets();
    Boolean uploadFile(String bucketName, String key, byte[] file);
    String downloadFile(String bucket, String key) throws IOException;
    List<String> listarArchivos(String bucket, String prefix);

    // Generar URL para conceder permiso temporal al frontend
    String generarUrlCarga(String bucketName, String key, Duration duration);
    String generarUrlDescarga(String bucketName, String key, Duration duration);
}
