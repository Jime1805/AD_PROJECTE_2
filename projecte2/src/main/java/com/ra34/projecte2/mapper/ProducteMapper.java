package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.ProducteResponseDTO;
import com.ra34.projecte2.model.Producte;

@Component
public class ProducteMapper {
    public ProducteResponseDTO toDto(Producte producte){
        if (producte == null) {
            return null;
        }

        ProducteResponseDTO dto = new ProducteResponseDTO(
            producte.getId(),
            producte.getNombre(),
            producte.getDescripcion(),
            producte.getStock(),
            producte.getPrice(),
            producte.getRating(),
            producte.getCondition()
        );

        return dto;
    }
}
