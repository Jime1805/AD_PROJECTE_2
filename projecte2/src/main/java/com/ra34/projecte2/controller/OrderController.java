package com.ra34.projecte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.dto.OrderRequestDTO;
import com.ra34.projecte2.dto.OrderResponseDTO;
import com.ra34.projecte2.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/customer/{customerId}/order")
    public ResponseEntity<OrderResponseDTO> createOrder(
            @PathVariable Long customerId,
            @RequestBody OrderRequestDTO request) {

        OrderResponseDTO created = orderService.createOrder(customerId, request);

        if (created == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/order/{id}/process")
    public ResponseEntity<OrderResponseDTO> processOrder(@PathVariable Long id) {
        OrderResponseDTO result = orderService.processOrder(id);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(result);
    }
}
