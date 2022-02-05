package com.odcode.customer.service;

import com.odcode.customer.entity.CustomerRegistrationRequest;
import com.odcode.customer.entity.Customer;
import com.odcode.customer.entity.FraudCheckResponse;
import com.odcode.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer= Customer.builder().firstname(customerRegistrationRequest.firstName())
                .lastname(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email()).build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8082/api/v1/isFraud/{customerId}", FraudCheckResponse.class
                , customer.getId());

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Is a fraudster");
        }


    }
}
