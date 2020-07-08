package com.sinacolada.tiki.service.impl;

import com.sinacolada.tiki.model.entity.Permission;
import com.sinacolada.tiki.repository.PermissionRepository;
import com.sinacolada.tiki.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Permission createPermission(Permission permission) {
        log.debug("CREATING permission: name={}", permission.getName());
        Permission createdPermission = permissionRepository.save(permission);
        log.debug("CREATED permission: name={}, id={}", permission.getName(), permission.getId());
        return createdPermission;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deletePermissionById(Integer id) {
        log.debug("DELETING permission: id={}", id);
        permissionRepository.deleteById(id);
        log.debug("DELETED permission: id={}", id);
    }

}