package com.sinacolada.tiki.repository;

import java.util.List;

import com.sinacolada.tiki.model.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    // public Integer createUser(User user);

    // @Query("select user from User user where user.id=:id")
    // public User findUserById(@Param("id") Integer id);

    @Query("select user from User user")
    List<User> getAllUsers();

    // public User updateUser(@Param("id") Integer id, User user);

    // public Integer deleteUser(@Param("id") Integer id);

}