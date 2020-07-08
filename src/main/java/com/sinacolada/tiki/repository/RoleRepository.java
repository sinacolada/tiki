package com.sinacolada.tiki.repository;

import com.sinacolada.tiki.model.entity.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}