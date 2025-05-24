package ru.mail.npv90.orderServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    private Long id;
    private String filename;
    private String fileKey;
}
