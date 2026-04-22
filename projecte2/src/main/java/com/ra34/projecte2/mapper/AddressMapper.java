package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.AddressDTO;
import com.ra34.projecte2.dto.AddressRequestDTO;
import com.ra34.projecte2.model.Address;

@Component
public class AddressMapper {

    public AddressDTO toDto(Address entity) {
        if (entity == null) {
            return null;
        }

        return new AddressDTO(
                entity.getId(),
                entity.getAddress(),
                entity.getCity(),
                entity.getPostalCode(),
                entity.getCountry(),
                entity.isDefault());
    }

    public Address toEntity(AddressRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Address address = new Address();
        address.setAddress(dto.getAddress());
        address.setCity(dto.getCity());
        address.setPostalCode(dto.getPostalCode());
        address.setCountry(dto.getCountry());
        address.setDefault(dto.isDefault());
        return address;
    }
}
