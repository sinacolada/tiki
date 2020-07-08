package com.sinacolada.tiki.repository;

import com.sinacolada.tiki.model.entity.Permission;

import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Integer> {
}