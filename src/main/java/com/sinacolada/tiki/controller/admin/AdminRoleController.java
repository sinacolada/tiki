package com.sinacolada.tiki.controller.admin;

import com.sinacolada.tiki.model.entity.Role;
import com.sinacolada.tiki.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("roleController")
// @RequestMapping("/admin/roles")
@RequestMapping("/roles")
public class AdminRoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRoleById(@PathVariable(name = "id") final Integer id) {
        roleService.deleteRoleById(id);
    }

}