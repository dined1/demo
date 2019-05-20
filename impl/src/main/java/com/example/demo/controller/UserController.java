package com.example.demo.controller;

import com.example.demo.mapper.SystemUserMapper;
import com.example.demo.model.SystemUserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userService")
public class UserController {

    private final UserService userService;
    private final SystemUserMapper systemUserMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.systemUserMapper = SystemUserMapper.INSTANCE;
    }

    @GetMapping("/getUser/{id}")
    public SystemUserDto getUser(@PathVariable String id){
        return systemUserMapper.toDto(userService.getUser(id));
    }

    @PostMapping("/create")
    public SystemUserDto createUser(@RequestBody SystemUserDto user){
        return systemUserMapper.toDto(userService.createUser(systemUserMapper.toObject(user)));
    }
}
