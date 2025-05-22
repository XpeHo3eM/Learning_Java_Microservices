package ru.mail.npv90.orderServer.dal;

import java.io.InputStream;

public interface S3Service {
    public String download(String key, InputStream inputStream, long contentLength, String contentType);
}
