package ru.mail.npv90.orderServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderServer.dal.OrderService;
import ru.mail.npv90.orderServer.dto.OrderDto;

import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class Controller {
    private final OrderService service;

    @PostMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto upload(@RequestParam MultipartFile file) {
        return service.upload(file);
    }

    @PostMapping(value = "/uploadMultiply", consumes = MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderDto> upload(@RequestParam List<MultipartFile> files) {
        return service.upload(files);
    }
}
