package com.example.demo.Services;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Transactional
    @Override
    public boolean chargePayment(String creditCardNumber, BigDecimal amount) {
        return true;
    }

}
