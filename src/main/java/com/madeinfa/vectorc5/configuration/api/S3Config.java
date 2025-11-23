package com.madeinfa.vectorc5.configuration.api;

import java.net.URI;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class S3Config {
    @Value("${aws.access.key}")
    private String awsAccessKey;
    @Value("${aws.secret.key}")
    private String awsPrivateKey;

    @Bean
    public S3Client getS3Client() {
        AwsCredentials basicCredentials = AwsBasicCredentials.create(awsAccessKey, awsPrivateKey);
        return S3Client.builder()
                .region(Region.US_EAST_1)
                .endpointOverride(URI.create("https://ewr1.vultrobjects.com"))
                .credentialsProvider(StaticCredentialsProvider.create(basicCredentials))
                .serviceConfiguration(S3Configuration.builder()
                        .pathStyleAccessEnabled(true)
                        .chunkedEncodingEnabled(false)
                        .build())
                .build();
    }

    @Bean
    public S3Presigner getS3Presigner() {
        AwsCredentials basicCredentials = AwsBasicCredentials.create(awsAccessKey, awsPrivateKey);
        return S3Presigner.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(basicCredentials))
                // TODO Completar URL
                .endpointOverride(URI.create("https://ewr1.vultrobjects.com"))
                .build();
    }
}
