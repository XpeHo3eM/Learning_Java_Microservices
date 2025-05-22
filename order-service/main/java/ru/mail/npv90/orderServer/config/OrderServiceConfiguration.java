package ru.mail.npv90.orderServer.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;


@Configuration
public class OrderServiceConfiguration {
    @Value("${s3.region")
    private String REGION;
    @Value("${s3.key-id")
    private String KEY_ID;
    @Value("${s3.key-secret")
    private String SECRET_KEY;

    @Value("${s3.bucket-name}")
    private String BUCKET;

    @Value("${s3.endpoint}")
    private String ENDPOINT;

    @Bean
    public AwsCredentials awsCredentials() {
        return AwsBasicCredentials.create(KEY_ID, SECRET_KEY);
    }

    @Bean
    public S3Client s3Client(AwsCredentials credentials) {
        return S3Client.builder()
                .httpClient(ApacheHttpClient.create())
                .region(Region.of(REGION))
                .endpointOverride(URI.create(ENDPOINT))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
