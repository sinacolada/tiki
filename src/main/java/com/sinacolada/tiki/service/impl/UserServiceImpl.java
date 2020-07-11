package com.sinacolada.tiki.service.impl;

import java.util.Optional;

import com.sinacolada.tiki.model.entity.User;
import com.sinacolada.tiki.repository.UserRepository;
import com.sinacolada.tiki.service.UserService;
import com.sinacolada.tiki.util.custom.exception.DuplicateEmailException;
import com.sinacolada.tiki.util.custom.exception.UsernameUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User createUser(User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        if (getUserByEmail(email) != null) {
            throw new DuplicateEmailException(String.format("Email %s is already in use", email));
        }
        if (getUserByUsername(username) != null) {
            throw new UsernameUnavailableException(String.format("Username %s is not available", username));
        }
        log.debug("CREATING new user: email={}, username={}", user.getEmail(), user.getUsername());
        User createdUser = userRepository.save(user);
        log.debug("CREATED new user: email={}, username={}", createdUser.getEmail(), createdUser.getUsername());
        return createdUser;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User getUserById(Long id) {
        log.debug("READING user: id={}", id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User readUser = user.get();
            log.debug("READ user: id={}, email={}, username={}", readUser.getId(), readUser.getEmail(),
                    readUser.getUsername());
            return readUser;
        }
        log.debug("Could not find user: id={}", id);
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User getUserByUsername(String username) {
        log.debug("READING user: username={}", username);
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            User readUser = user.get();
            log.debug("READ user: id={}, email={}, username={}", readUser.getId(), readUser.getEmail(),
                    readUser.getUsername());
            return readUser;
        }
        log.debug("Could not find user: username={}", username);
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User getUserByEmail(String email) {
        log.debug("READING user: email={}", email);
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            User readUser = user.get();
            log.debug("READ user: id={}, email={}, username={}", readUser.getId(), readUser.getEmail(),
                    readUser.getUsername());
            return readUser;
        }
        log.debug("Could not find user: email={}", email);
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User updateUserById(Long id, User user) {
        // user.setId(id);
        // return userRepository.save(user);
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User updateUserByUsername(String username, User user) {
        return null;
    }

}