package ru.mail.npv90.orderServer.dal.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderServer.dal.OrderService;
import ru.mail.npv90.orderServer.dal.S3Service;
import ru.mail.npv90.orderServer.dao.OrderRepository;
import ru.mail.npv90.orderServer.dto.OrderDto;
import ru.mail.npv90.orderServer.mapper.OrderMapper;
import ru.mail.npv90.orderServer.model.OrderEntity;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final S3Service s3Service;
    private final OrderMapper mapper;

    @Override
    public OrderDto download(MultipartFile file) {
        OrderEntity newOrderEntity = OrderEntity.builder()
                .filename(file.getOriginalFilename())
                .build();

        orderRepository.save(newOrderEntity);

        String fileKey = String.format("invoices/order-%s.%s",
                newOrderEntity.getId(),
                StringUtils.getFilenameExtension(file.getOriginalFilename()));
        String fileUrl = s3Service.download(file);
        newOrderEntity.setFileUrl(fileUrl);

        return mapper.toDto(orderRepository.save(newOrderEntity));
    }
}
