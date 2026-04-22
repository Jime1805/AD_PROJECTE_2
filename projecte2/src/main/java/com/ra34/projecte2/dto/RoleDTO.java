package com.ra34.projecte2.dto;

import com.ra34.projecte2.model.RoleName;

public class RoleDTO {

    private Long id;
    private RoleName name;

    public RoleDTO() {
    }

    public RoleDTO(Long id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
