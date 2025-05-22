package ru.mail.npv90.orderService.dal.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderService.dal.OrderService;
import ru.mail.npv90.orderService.dao.OrderRepository;
import ru.mail.npv90.orderService.dto.OrderDto;
import ru.mail.npv90.orderService.mapper.OrderMapper;
import ru.mail.npv90.orderService.model.OrderEntity;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final String PATH_TO_DOWNLOAD = "downloads";
    @Override
    public OrderDto download(MultipartFile file) {
        File directory = new File(PATH_TO_DOWNLOAD);
        if (!directory.exists()) {
            directory.mkdir();
        }

        String fileName = file.getOriginalFilename();
        File destFile = new File(directory, fileName);
        try {
            file.transferTo(destFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        OrderEntity newEntity = OrderEntity.builder()
                .filename(fileName)
                .fileUrl(destFile.getAbsolutePath())
                .build();

        return mapper.toDto(orderRepository.save(newEntity));
    }
}
