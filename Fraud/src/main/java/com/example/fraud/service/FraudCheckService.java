package com.example.fraud.service;

import com.example.fraud.entity.FraudCheckHistory;
import com.example.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FraudCheckService {
    @Autowired
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public Boolean isFraudulent(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .createdAt(LocalDate.now())
                        .isAFraudster(false)
                .build());
        return  false;
    }
}
