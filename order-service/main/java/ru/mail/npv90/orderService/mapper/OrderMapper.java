package ru.mail.npv90.orderService.mapper;

import org.mapstruct.Mapper;
import ru.mail.npv90.orderService.dto.NewOrder;
import ru.mail.npv90.orderService.dto.OrderDto;
import ru.mail.npv90.orderService.model.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(NewOrder newOrder);
    OrderDto toDto(OrderEntity orderEntity);
}
