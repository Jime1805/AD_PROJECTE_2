package com.ra34.projecte2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.InvoiceResponseDTO;
import com.ra34.projecte2.dto.OrderItemResponseDTO;
import com.ra34.projecte2.dto.OrderRequestDTO;
import com.ra34.projecte2.dto.OrderResponseDTO;
import com.ra34.projecte2.model.Customer;
import com.ra34.projecte2.model.Order;
import com.ra34.projecte2.model.OrderItem;

@Component
public class OrderMapper {

    @Autowired
    OrderItemMapper orderItemMapper; // per pasar a dto

    @Autowired
    InvoiceMapper invoiceMapper; // per pasar a dto

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

    public Order toEntity(OrderRequestDTO request, Customer customer){
        if (request == null) {
            return null;
        }
        Order order = new Order();

        order.setCustomers(customer);
        order.setOrderDate(request.getOrderDate());
        order.setTotalAmount(0);
        order.setOrderStatus("PENDENT");
        order.setStatus(true);

        return order;
    }
}