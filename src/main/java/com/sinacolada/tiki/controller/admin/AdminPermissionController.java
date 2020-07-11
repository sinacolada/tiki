package com.sinacolada.tiki.controller.admin;

import com.sinacolada.tiki.model.entity.Permission;
import com.sinacolada.tiki.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("permissionsController")
// @RequestMapping("/admin/permissions")
@RequestMapping("/permissions")
public class AdminPermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public Permission createPermission(@RequestBody Permission permission) {
        return permissionService.createPermission(permission);
    }

    @DeleteMapping("/{id}")
    public void deletePermissionById(@PathVariable(name = "id") final Integer id) {
        permissionService.deletePermissionById(id);
    }

}