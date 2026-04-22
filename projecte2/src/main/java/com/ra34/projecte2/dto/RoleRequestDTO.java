package com.ra34.projecte2.dto;

import com.ra34.projecte2.model.RoleName;

public class RoleRequestDTO {

    private RoleName name;

    public RoleRequestDTO() {
    }

    public RoleRequestDTO(RoleName name) {
        this.name = name;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
