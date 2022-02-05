package com.example.fraud.controller;

import com.example.fraud.entity.FraudCheckResponse;
import com.example.fraud.service.FraudCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1")
public class FraudCheckController {
    @Autowired
    private FraudCheckService fraudCheckService;
    @GetMapping("/isFraud/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId){
        Boolean fraudulent = fraudCheckService.isFraudulent(customerId);
        return new FraudCheckResponse(fraudulent);

    }
}
