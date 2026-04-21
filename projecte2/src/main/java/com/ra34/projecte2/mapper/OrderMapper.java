package com.ra34.projecte2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceResponseDTO;
import com.ra34.projecte2.dto.OrderItemResponseDTO;
import com.ra34.projecte2.dto.OrderResponseDTO;
import com.ra34.projecte2.model.Order;
import com.ra34.projecte2.model.OrderItem;

@Component
public class OrderMapper {

    @Autowired
    OrderItemMapper orderItemMapper; // per pasar a dto

    @Autowired
    InvoiceMapper invoiceMapper; // per pasar a dto

    // Converteix una entitat Order a OrderResponseDTO
    public OrderResponseDTO toDto(Order order) {
        if (order == null) return null;

        List<OrderItemResponseDTO> itemDtos = new ArrayList<>();
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                itemDtos.add(orderItemMapper.toDto(item));
            }
        }

        InvoiceResponseDTO invoiceDTO = null;
        if (order.getInvoice() != null) {
            invoiceDTO = invoiceMapper.toDto(order.getInvoice());
        }

        return new OrderResponseDTO(
            order.getId(),
            order.getOrderDate(),
            order.getTotalAmount(),
            order.getOrderStatus(),
            itemDtos,
            invoiceDTO
        );
    }
}