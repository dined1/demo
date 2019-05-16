package com.example.demo.controller;

import com.example.demo.model.SystemUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public SystemUser getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public SystemUser createUser(@RequestBody SystemUser user){
        return userService.createUser(user);
    }
}
