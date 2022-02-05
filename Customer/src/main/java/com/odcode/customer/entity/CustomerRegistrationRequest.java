package com.odcode.customer.entity;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {

}
