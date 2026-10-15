
package com.example.ordervalidation.controller;

import com.example.ordervalidation.dto.OrderDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(
            @Valid @RequestBody OrderDTO order) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("message", "Order created successfully");
        response.put("customerName", order.getCustomerName());
        response.put("productName", order.getProductName());
        response.put("quantity", order.getQuantity());
        response.put("price", order.getPrice());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
