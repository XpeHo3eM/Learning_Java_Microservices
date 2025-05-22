package ru.mail.npv90.orderServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.npv90.orderServer.dal.OrderService;
import ru.mail.npv90.orderServer.dto.OrderDto;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class Controller {
    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto download(@RequestParam MultipartFile file) {
        return service.download(file);
    }
}
