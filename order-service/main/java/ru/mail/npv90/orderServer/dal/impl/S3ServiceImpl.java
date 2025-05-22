package ru.mail.npv90.orderServer.dal.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.mail.npv90.orderServer.dal.S3Service;

import java.io.InputStream;


@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    @Value("${s3.bucket-name}")
    private final String bucketName;
    private final AmazonS3 client;

    @Override
    public String download(String key, InputStream inputStream, long contentLength, String contentType) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(
                        new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(
                                "https://storage.yandexcloud.net",
                                "ru-central1"
                        )
                )
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKeyId, secretAccessKey)))
                .build();
    }
}
