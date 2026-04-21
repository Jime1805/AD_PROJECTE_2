package com.ra34.projecte2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.OrderItemDTO;
import com.ra34.projecte2.dto.ProductResponse;
import com.ra34.projecte2.model.OrderItem;
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
            List<OrderItemDTO> itemDtos = new ArrayList<>();

            for (OrderItem item : producte.getOrderItems()) {
                OrderItemDTO oiDto = new OrderItemDTO(
                    item.getId(),
                    null,
                    null,
                    item.getQuantity(),
                    item.getUntilPrice()
                );
                itemDtos.add(oiDto);
            }

            dto.setOrderItem(itemDtos);
        }
        return dto;
    }
}
