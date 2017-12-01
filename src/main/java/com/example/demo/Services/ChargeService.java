package com.example.demo.Services;

import java.math.BigDecimal;

public interface ChargeService {
    boolean chargePayment(String creditCardNumber, BigDecimal amount);
}
