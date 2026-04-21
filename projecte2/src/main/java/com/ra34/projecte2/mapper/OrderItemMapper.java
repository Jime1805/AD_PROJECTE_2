package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.OrderDTO;
import com.ra34.projecte2.dto.OrderItemDTO;
import com.ra34.projecte2.model.OrderItem;

@Component
public class OrderItemMapper {
    public OrderItemDTO toDto(OrderItem orderItem){
        if (orderItem == null) {
            return null;
        }

        OrderItemDTO dto = new OrderItemDTO(
            orderItem.getId(),
            null,
            null,
            orderItem.getQuantity(),
            orderItem.getUntilPrice()
        );
        if (orderItem.getOrder() != null) {
            OrderDTO oiDto = new OrderDTO(
                orderItem.getOrder().getId(),
                null,
                null,
                orderItem.getOrder().getOrderDate(),
                orderItem.getOrder().getTotalAmount(),
                orderItem.getOrder().getOrderStatus()
            );
            dto.setOrder(oiDto);
        }
        return dto;
    }
}
