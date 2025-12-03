package com.firstproject.DemoProject.controller;

import com.firstproject.DemoProject.entity.User;
import com.firstproject.DemoProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User Added Successfully";
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
