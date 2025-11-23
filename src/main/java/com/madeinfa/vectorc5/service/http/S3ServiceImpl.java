package com.madeinfa.vectorc5.service.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.madeinfa.vectorc5.service.interfaces.IS3Service;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

//@Service
//public class S3ServiceImpl implements IS3Service{
//
//    @Value("${spring.destination.folder}")
//    private String destinationFolder;
//
//    private final S3Client s3Client;
//    private final S3Presigner s3Presigner;
//
//    public S3ServiceImpl(S3Client s3Client, S3Presigner s3Presigner) {
//        this.s3Client = s3Client;
//        this.s3Presigner = s3Presigner;
//    }
//
//    @Override
//    public String crearBucket(String bucketName) {
//        CreateBucketResponse respuesta = this.s3Client.createBucket(bucketBuilder -> bucketBuilder.bucket(bucketName));
//        return "Bucket creado en la ubicacion: " + respuesta.location();
//    }
//
//    @Override
//    public boolean verificarExistenciaBucket(String bucketName) {
//        try {
//            this.s3Client.headBucket(headBucket -> headBucket.bucket(bucketName));
//            return true;
//        } catch (S3Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public List<String> getAllBuckets() {
//        ListBucketsResponse bucketsResponse = this.s3Client.listBuckets();
//        if(bucketsResponse.hasBuckets()) {
//            return bucketsResponse.buckets().stream().map(Bucket::name).toList();
//        } else {
//            return List.of();
//        }
//    }
//
//    @Override
//    public Boolean uploadFile(String bucketName, String key, byte[] file) {
//        PutObjectRequest request = PutObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .contentLength((long) file.length)
//                .build();
//
//        PutObjectResponse response = this.s3Client.putObject(request, RequestBody.fromBytes(file));
//        return response.sdkHttpResponse().isSuccessful();
//    }
//
//    @Override
//    public String downloadFile(String bucket, String key) throws IOException {
//        GetObjectRequest request = GetObjectRequest.builder()
//                .bucket(bucket)
//                .key(key)
//                .build();
//
//        ResponseBytes<GetObjectResponse> objBytes = this.s3Client.getObjectAsBytes(request);
//
//        String fileName;
//        if(key.contains("/")) {
//            fileName = key.substring(key.indexOf("/"), key.length());
//        } else {
//            fileName = key;
//        }
//
//        String filePath = Paths.get(destinationFolder, fileName).toString();
//
//        File file = new File(filePath);
//        file.getParentFile().mkdir();
//
//        try(FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write(objBytes.asByteArray());
//            return filePath;
//        } catch(IOException ex) {
//            throw new IOException("Error al descargar el archivo " + ex.getCause());
//        }
//    }
//
//    @Override
//    public String generarUrlCarga(String bucketName, String key, Duration duration) {
//
//        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
//                .signatureDuration(duration)
//                .putObjectRequest(req -> {
//                    req.bucket(bucketName);
//                    req.key(key);
//                })
//                .build();
//
//        PresignedPutObjectRequest presignedPutRequest = this.s3Presigner.presignPutObject(presignRequest);
//        return presignedPutRequest.url().toString();
//    }
//
//    @Override
//    public String generarUrlDescarga(String bucketName, String key, Duration duration) {
//
//        GetObjectPresignRequest presignRequest =  GetObjectPresignRequest.builder()
//                .signatureDuration(duration)
//                .getObjectRequest(req -> {
//                    req.bucket(bucketName);
//                    req.key(key);
//                })
//                .build();
//
//        PresignedGetObjectRequest presignedRequest = s3Presigner.presignGetObject(presignRequest);
//        return presignedRequest.url().toString();
//    }
//
//    @Override
//    public List<String> listarArchivos(String bucket, String prefix) {
//        try {
//            List<S3Object> lista = s3Client.listObjects(obj -> obj.bucket(bucket).prefix(prefix)).contents();
//            return lista.stream().map(S3Object::key).toList();
//        } catch (S3Exception ex) {
//            return Collections.emptyList();
//        }
//    }
//
//}
//