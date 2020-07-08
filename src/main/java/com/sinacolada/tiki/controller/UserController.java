package com.sinacolada.tiki.controller;

import java.util.List;
import java.util.Optional;

import com.sinacolada.tiki.model.entity.User;
import com.sinacolada.tiki.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController("userController")
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(User user) {
        log.debug("Creating new user: email={}, username={}", user.getEmail(), user.getUsername());
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") final Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") final Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // @DeleteMapping("/{id}")
    // public Integer deleteUser(@PathVariable(name = "id") final Integer id) {
    // return userRepository.delete(id);
    // }

}