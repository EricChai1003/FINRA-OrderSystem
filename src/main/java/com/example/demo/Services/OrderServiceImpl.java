package com.example.demo.Services;

import com.example.demo.Entities.Order;
import com.example.demo.Repositories.InventoryDAO;
import com.example.demo.Repositories.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final InventoryDAO inventoryDAO;

    @Autowired
    public OrderServiceImpl(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public Order getOrder(String orderId) {
        return orderDAO.getOrderByOrderId(orderId);
    }
}
