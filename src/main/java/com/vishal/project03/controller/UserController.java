package com.vishal.project03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.project03.enity.User;
import com.vishal.project03.service.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/getAll")
    public List<User> getAllUsers(
        @RequestParam(required = false) String search,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return userServiceImpl.getAll(search, sortBy, sortDirection);
    }

    @GetMapping("/getById")
    public User getUserById(@RequestParam Long id) {
        return userServiceImpl.getById(id);
    }

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userServiceImpl.updateById(user.getId(), user);
    }

    @DeleteMapping("/deleteById")
    public void deleteUser(@RequestParam Long id) {
        userServiceImpl.deleteById(id);
    }

    @PostMapping("/saveAll")
    public List<User> saveAllUsers(@RequestBody List<User> users) {
        return userServiceImpl.saveAll(users);
    }

    @PostMapping("/addCustomerUser")
    public User addCustomerUser(@RequestParam Long customerId, @RequestBody User user) {
        return userServiceImpl.addCustomerUser(customerId, user);
    }
}