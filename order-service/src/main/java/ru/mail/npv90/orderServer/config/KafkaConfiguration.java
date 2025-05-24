package ru.mail.npv90.orderServer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.mail.npv90.orderServer.dto.OrderDto;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@RequiredArgsConstructor
public class KafkaConfiguration {
//    private final KafkaDefaultConfiguration config;
//
//    @Bean
//    public ConsumerFactory<String, OrderDto> consumerOrderListenerFactory() {
//        DefaultKafkaConsumerFactory<String, OrderDto> factory = consumerFactory(OrderDto.class);
//        factory.setKeyDeserializer(new StringDeserializer());
//        return factory;
//    }
//
//    @Bean
//    public ProducerFactory<String, OrderDto> producerOrderFactory() {
//        return new DefaultKafkaProducerFactory<>(generateDefaultProps(OrderDto.class));
//    }
//
//    @Bean
//    public KafkaTemplate<String, OrderDto> kafkaTemplate(ProducerFactory<String, OrderDto> producerOrderFactory) {
//        return new KafkaTemplate<>(producerOrderFactory);
//    }
//
//    private <T> Map<String, Object> generateDefaultProps(Class<T> tClass) {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, tClass);
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
//        props.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, JsonDeserializer.class);
//
//        return props;
//    }
//
//    private <T> DefaultKafkaConsumerFactory<String, T> consumerFactory(Class<T> dto) {
//        return new DefaultKafkaConsumerFactory<>(generateDefaultProps(dto));
//    }
}
