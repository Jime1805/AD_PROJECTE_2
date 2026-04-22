package com.ra34.projecte2.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.AddressDTO;
import com.ra34.projecte2.dto.CustomerDTO;
import com.ra34.projecte2.dto.CustomerRequestDTO;
import com.ra34.projecte2.model.Customer;

@Component
public class CustomerMapper {

    @Autowired
    private AddressMapper addressMapper;

    public CustomerDTO toDto(Customer entity) {
        if (entity == null) {
            return null;
        }

        String userEmail = (entity.getUser() != null) ? entity.getUser().getEmail() : null;

        CustomerDTO dto = new CustomerDTO(
                entity.getId(),
                userEmail,
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhone());

        if (entity.getAddresses() != null) {
            List<AddressDTO> addressDTOs = entity.getAddresses().stream()
                    .map(addressMapper::toDto)
                    .collect(Collectors.toList());
            dto.setAddresses(addressDTOs);
        }

        return dto;
    }

    public Customer toEntity(CustomerRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setPhone(dto.getPhone());
        customer.setStatus(true);
        return customer;
    }
}
