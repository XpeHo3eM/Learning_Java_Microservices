package ru.mail.npv90.orderServer.dal;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface S3Service {
    String upload(MultipartFile file) throws IOException;
    List<String> upload(List<MultipartFile> files) throws IOException;
}
