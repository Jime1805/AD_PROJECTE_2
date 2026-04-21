package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.ProducteResponseDTO;
import com.ra34.projecte2.dto.OrderItemResponseDTO;
import com.ra34.projecte2.model.OrderItem;

@Component
public class OrderItemMapper {
    public OrderItemResponseDTO toDto(OrderItem orderItem){
        if (orderItem == null) {
            return null;
        }

        OrderItemResponseDTO dto = new OrderItemResponseDTO(
            orderItem.getId(),
            orderItem.getQuantity(),
            orderItem.getUntilPrice(),
            null
        );
        if (orderItem.getProducte() != null) {
            ProducteResponseDTO oiDto = new ProducteResponseDTO(
                orderItem.getProducte().getId(),
                orderItem.getProducte().getNombre(),
                orderItem.getProducte().getDescripcion(),
                orderItem.getProducte().getStock(),
                orderItem.getProducte().getPrice(),
                orderItem.getProducte().getRating(),
                orderItem.getProducte().getCondition()

            );
            dto.setProducte(oiDto);
        }
        return dto;
    }
}
