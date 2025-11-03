package com.example.ecommerce.product;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product ID is mandatory")
        Integer productId,
        @NotNull(message = "Product quantity is mandatory")
        double quantity
) {
}
