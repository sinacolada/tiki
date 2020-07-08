package com.sinacolada.tiki.service;

import com.sinacolada.tiki.model.entity.Permission;

public interface PermissionService {

    Permission createPermission(Permission permission);

    void deletePermissionById(Integer id);

}