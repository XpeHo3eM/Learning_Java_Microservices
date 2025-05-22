package ru.mail.npv90.orderService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.npv90.orderService.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
