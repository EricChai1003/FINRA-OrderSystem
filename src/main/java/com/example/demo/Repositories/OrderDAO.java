package com.example.demo.Repositories;

import com.example.demo.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, String> {

    Order getOrderByOrderId(String id);
}
