package com.example.demo.Repositories;

import com.example.demo.Entities.Inventory;
import com.example.demo.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDAO extends JpaRepository<Inventory, String> {
}
