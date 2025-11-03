package com.example.ecommerce.order;

import com.example.ecommerce.customer.CustomerClient;
import com.example.ecommerce.exception.BusinessException;
import com.example.ecommerce.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private CustomerClient customerClient;
    private ProductClient productClient;
    public Integer createdOrder(OrderRequest request) {
        // check the customer(feign)
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(()->new BusinessException("Cannot create order. Customer requested not found with the provided ID::"));

        // purchase the products --> product-ms(rest)
        this.productClient.purchaseProducts(request.products());
        // persist order

        // persist order lines

        // start payment process

        // send the order confirmation --> notification-ms(kafka)
        return null;
    }
}
