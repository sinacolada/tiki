package com.sinacolada.tiki.service;

import com.sinacolada.tiki.model.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    User updateUserById(Long id, User user);

    User updateUserByUsername(String username, User user);

}