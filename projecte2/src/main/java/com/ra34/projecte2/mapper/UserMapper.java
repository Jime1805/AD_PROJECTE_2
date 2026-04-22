package com.ra34.projecte2.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.CustomerDTO;
import com.ra34.projecte2.dto.RoleDTO;
import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.model.User;

@Component
public class UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    public UserDTO toDto(User entity) {
        if (entity == null) {
            return null;
        }

        UserDTO dto = new UserDTO(entity.getId(), entity.getEmail());

        if (entity.getRoles() != null) {
            List<RoleDTO> roleDTOs = entity.getRoles().stream()
                    .map(roleMapper::toDto)
                    .collect(Collectors.toList());
            dto.setRoles(roleDTOs);
        }

        if (entity.getCustomer() != null) {
            CustomerDTO customerDTO = new CustomerDTO(
                    entity.getCustomer().getId(),
                    entity.getEmail(),
                    entity.getCustomer().getFirstName(),
                    entity.getCustomer().getLastName(),
                    entity.getCustomer().getPhone());
            dto.setCustomer(customerDTO);
        }

        return dto;
    }

    public User toEntity(UserRequest dto) {
        if (dto == null) {
            return null;
        }

        return new User(null, dto.getEmail(), dto.getPassword());
    }
}
