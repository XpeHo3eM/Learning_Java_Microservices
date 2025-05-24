package ru.mail.npv90.orderServer.dto;


import jakarta.validation.constraints.NotBlank;

public record NewOrder(
        @NotBlank
        String filename) {
}
