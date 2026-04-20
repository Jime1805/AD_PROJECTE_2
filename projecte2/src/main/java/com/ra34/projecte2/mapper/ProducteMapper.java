package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.OrderItemDTO;
import com.ra34.projecte2.dto.ProductResponse;
import com.ra34.projecte2.model.Producte;

@Component
public class ProducteMapper {
    public ProductResponse toDto(Producte producte){
        if (producte == null) {
            return null;
        }

        ProductResponse dto = new ProductResponse(
            producte.getId(),
            null,
            producte.getNombre(),
            producte.getDescripcion(),
            producte.getStock(),
            producte.getPrice(),
            producte.getRating(),
            producte.getCondition()
        );

        if (producte.getOrderItems() != null) {
            OrderItemDTO oiDto = new OrderItemDTO(
                producte.getOrderItems().get(0).getId(),
                null, //OrderDTO
                null,
                producte.getOrderItems().get(0).getQuantity(),            
                producte.getOrderItems().get(0).getUntilPrice()
            );
            dto.setOrderItem(oiDto);
        }
        return dto;
    }
}
