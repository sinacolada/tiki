package com.sinacolada.tiki.service;

import com.sinacolada.tiki.model.entity.Role;

public interface RoleService {

    Role createRole(Role role);

    void deleteRoleById(Integer id);

}