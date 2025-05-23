package ru.mail.npv90.orderServer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KafkaDefaultConfiguration {
    @Value("${kafka.bootstrap.server}")
    private String servers;

    @Value("${kafka.topic.order-requested}")
    private String orderRequestedTopic;

    @Value("${kafka.topic.order-created}")
    private String orderCreatedTopic;
}
