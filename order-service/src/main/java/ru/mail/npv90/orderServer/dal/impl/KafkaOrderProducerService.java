package ru.mail.npv90.orderServer.dal.impl;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.aspectj.weaver.ast.Or;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.mail.npv90.orderServer.config.KafkaDefaultConfiguration;
import ru.mail.npv90.orderServer.dto.OrderDto;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class KafkaOrderProducerService {
    private final KafkaDefaultConfiguration config;
    private final KafkaTemplate<String, String> template;

    public void send(OrderDto orderDto) {
        template.send(config.getOrderCreatedTopic(),
                UUID.randomUUID().toString(),
                orderDto.toString());
    }

    public void send(List<OrderDto> orderDtos) {
        for (OrderDto orderDto : orderDtos) {
            send(orderDto);
        }
    }
}
