package com.example.demo.Services;

import com.example.demo.Entities.Inventory;
import com.example.demo.Repositories.InventoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInventoryServiceImpl implements CheckInventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    @Override
    public boolean checkInventory(String productId, int quantity) {
        Inventory inventory = inventoryDAO.getOne(productId);
        if (inventory.getQuantity() >= quantity) {
            return true;
        } else {
            return false;
        }
    }
}
