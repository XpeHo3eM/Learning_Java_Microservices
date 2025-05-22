package ru.mail.npv90.orderService.dto;


import jakarta.validation.constraints.NotBlank;

public record NewOrder(
        @NotBlank
        String filename) {
}
