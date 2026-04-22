package com.ra34.projecte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.dto.OrderResponseDTO;
import com.ra34.projecte2.mapper.OrderMapper;
import com.ra34.projecte2.model.Order;
import com.ra34.projecte2.service.OrderService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @PatchMapping("/order/{orderId}/productes") // 4. Gestió d'orders c (Integrant 2)
    public ResponseEntity<?> addProductToOrder(@PathVariable Long orderId, @RequestBody List<Long> ProductesId){
        Order update = orderService.saveProductesToOrder(orderId, ProductesId);

        if (update == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order no trobat amb id: " + orderId);
        }

        OrderResponseDTO response = orderMapper.toDto(update);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/order/{id}/cancelat") // 4. Gestió d'orders d (Integrant 2)
    public ResponseEntity<?> cancelProductesinOrder(@PathVariable Long orderId){
        Order update = orderService.cancelOrder(orderId);

        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No es pot cancelar. L'Id de l'order no existeix o el seu status no es PENDENT.");
        }

        OrderResponseDTO response = orderMapper.toDto(update);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
