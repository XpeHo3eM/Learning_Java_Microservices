package ru.mail.npv90.orderServer.dal;

import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderServer.dto.OrderDto;

import java.io.IOException;

public interface OrderService {
    OrderDto download(MultipartFile file);
}
