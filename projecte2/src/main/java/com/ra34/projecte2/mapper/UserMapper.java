package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.CustomerDTO;
import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.model.User;

@Component
public class UserMapper {

    public UserDTO tDto(User entity) {
        if (entity == null)
            return null;

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setRoles(entity.getRoles());

        if (entity.getCustomer() != null) {
            CustomerDTO customerDTO = new CustomerDTO(
                    entity.getCustomer().getId(),
                    entity.getCustomer().getFirstName(),
                    entity.getCustomer().getLastName(),
                    entity.getCustomer().getPhone());
            customerDTO.setUser(dto);

            dto.setCustomer(customerDTO);
        }

        return dto;
    }

    public User toEntity(UserRequest dto) {
        if (dto == null)
            return null;

        User entity = new User(null, dto.getEmail(), dto.getPassword());

        return entity;
    }
}
