package com.sinacolada.tiki.controller;

import java.util.List;

import com.sinacolada.tiki.model.entity.User;
import com.sinacolada.tiki.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userController")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Integer createUser(User user) {
        return userRepository.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") final Integer id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") final Integer id, User user) {
        return userRepository.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable(name = "id") final Integer id) {
        return userRepository.deleteUser(id);
    }

}