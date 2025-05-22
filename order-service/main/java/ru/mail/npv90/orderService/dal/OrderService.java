package ru.mail.npv90.orderService.dal;

import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderService.dto.OrderDto;

public interface OrderService {
    OrderDto download(MultipartFile file);
}
