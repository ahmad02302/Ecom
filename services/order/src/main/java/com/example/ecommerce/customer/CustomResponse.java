package com.example.ecommerce.customer;

public record CustomResponse(
        String Id,
        String firstName,
        String lastName,
        String email
) {
}
