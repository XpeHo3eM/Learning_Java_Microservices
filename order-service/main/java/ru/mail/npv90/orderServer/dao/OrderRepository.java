package ru.mail.npv90.orderServer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.npv90.orderServer.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
