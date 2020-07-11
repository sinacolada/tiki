package com.sinacolada.tiki.repository;

import java.util.Optional;

import com.sinacolada.tiki.model.entity.Role;
import com.sinacolada.tiki.model.pojo.ERole;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);

}