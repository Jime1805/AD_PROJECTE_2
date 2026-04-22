package com.ra34.projecte2.mapper;

import org.springframework.stereotype.Component;

import com.ra34.projecte2.dto.RoleDTO;
import com.ra34.projecte2.dto.RoleRequestDTO;
import com.ra34.projecte2.model.Role;

@Component
public class RoleMapper {

    public RoleDTO toDto(Role entity) {
        if (entity == null) {
            return null;
        }

        return new RoleDTO(entity.getId(), entity.getName());
    }

    public Role toEntity(RoleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Role role = new Role();
        role.setName(dto.getName());
        return role;
    }
}
