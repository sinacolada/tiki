package com.sinacolada.tiki.service.impl;

import com.sinacolada.tiki.model.entity.Role;
import com.sinacolada.tiki.repository.RoleRepository;
import com.sinacolada.tiki.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Role createRole(Role role) {
        log.debug("CREATING role: name={}", role.getName());
        Role createdRole = roleRepository.save(role);
        log.debug("CREATED role: name={}, id={}", createdRole.getName(), createdRole.getId());
        return createdRole;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteRoleById(Integer id) {
        log.debug("DELETING role: id={}", id);
        roleRepository.deleteById(id);
        log.debug("DELETED role: id={}", id);
    }

}