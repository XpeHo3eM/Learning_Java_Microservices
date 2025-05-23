package ru.mail.npv90.orderServer.dal.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderServer.dal.OrderService;
import ru.mail.npv90.orderServer.dal.S3Service;
import ru.mail.npv90.orderServer.dao.OrderRepository;
import ru.mail.npv90.orderServer.dto.OrderDto;
import ru.mail.npv90.orderServer.mapper.OrderMapper;
import ru.mail.npv90.orderServer.model.OrderEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final S3Service s3Service;
    private final OrderMapper mapper;

    @Override
    public OrderDto upload(MultipartFile file) {
        String fileKey;
        try {
            fileKey = s3Service.upload(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return mapper.toDto(orderRepository.save(createOrderEntity(file, fileKey)));
    }

    @Override
    public List<OrderDto> upload(List<MultipartFile> files) {
        List<String> fileKeys;
        try {
            fileKeys = s3Service.upload(files);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<OrderEntity> orderEntities = new ArrayList<>();
        for (String fileKey : fileKeys) {
            MultipartFile currentFile = files.stream()
                    .filter(file -> fileKey.contains(file.getOriginalFilename()))
                    .findFirst()
                    .orElseThrow();

            orderEntities.add(createOrderEntity(currentFile, fileKey));
        }

        return mapper.toDto(orderRepository.saveAll(orderEntities));
    }

    private OrderEntity createOrderEntity(MultipartFile file, String fileKey) {
        return OrderEntity.builder()
                .filename(file.getOriginalFilename())
                .fileKey(fileKey)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
