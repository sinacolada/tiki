package com.sinacolada.tiki.controller.admin;

import com.sinacolada.tiki.model.entity.User;
import com.sinacolada.tiki.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userController")
// @RequestMapping("/admin/users")
@RequestMapping("/users")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") final Long id) {
        return userService.getUserById(id);
    }

    // @PutMapping("/{id}")
    // public User updateUser(@PathVariable(name = "id") final Long id, @RequestBody
    // User user) {
    // return userService.updateUserById(id, user);
    // }

    // @GetMapping("/all")
    // public List<User> getAllUsers() {
    // return userRepository.getAllUsers();
    // }

    // @DeleteMapping("/{id}")
    // public Integer deleteUser(@PathVariable(name = "id") final Integer id) {
    // return userRepository.delete(id);
    // }

}