package com.example.demo.Controllers;

import com.example.demo.Entities.Order;
import com.example.demo.Services.ChargeService;
import com.example.demo.Services.CheckInventoryService;
import com.example.demo.Services.OrderService;
import com.example.demo.Utilities.EmailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CheckInventoryService checkInventoryService;

    @Autowired
    private ChargeService chargeService;


    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable String id) {

        Order order = orderService.getOrder(id);
        if (checkInventoryService.checkInventory(order.getInventoryId(), order.getQuantity())) {
            chargeService.chargePayment(order.getCreditCardNumber(), order.getAmount());
            EmailUtility.sendEmail("Order successfully!", EmailUtility.toEmail, EmailUtility.fromEmail);
            return order;
        } else {
            throw new RuntimeException("Not enough products");
        }
    }
}
