package com.sinacolada.tiki.repository;

// import java.util.List;
import java.util.Optional;

import com.sinacolada.tiki.model.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    // public Integer createUser(User user);

    // @Query("select user from User user where user.id=:id")
    // public User findUserById(@Param("id") Integer id);

    @Query("select user from User user where user.username=:username")
    Optional<User> findUserByUsername(@Param("username") String username);

    @Query("select user from User user where user.email=:email")
    Optional<User> findUserByEmail(@Param("email") String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    // User updateUserByUsername(String username);

    // @Query("select user from User user")
    // List<User> getAllUsers();

    // public User updateUser(@Param("id") Integer id, User user);

    // public Integer deleteUser(@Param("id") Integer id);

}