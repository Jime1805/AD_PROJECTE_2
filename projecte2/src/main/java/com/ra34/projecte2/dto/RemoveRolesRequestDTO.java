package com.ra34.projecte2.dto;

import java.util.List;

public class RemoveRolesRequestDTO {

    private List<Long> roleIds;

    public RemoveRolesRequestDTO() {
    }

    public RemoveRolesRequestDTO(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
