package ru.mail.npv90.orderServer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mail.npv90.orderServer.dto.NewOrder;
import ru.mail.npv90.orderServer.dto.OrderDto;
import ru.mail.npv90.orderServer.model.OrderEntity;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(NewOrder newOrder);
    OrderDto toDto(OrderEntity orderEntity);
}
