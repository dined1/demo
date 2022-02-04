package com.example.demo.controller;

import com.example.demo.mapper.SystemUserMapper;
import com.example.demo.model.Constants;
import com.example.demo.model.SystemUser;
import com.example.demo.model.SystemUserDto;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Log4j2
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final SystemUserMapper systemUserMapper;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UserDetailsService userDetailsService, UserService userService, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.systemUserMapper = SystemUserMapper.INSTANCE;
    }

    @PostMapping("/login")
    public SystemUserDto login(@RequestBody @Valid SystemUserDto user) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        log.info(userDetails);
        String token = autologin(user, userDetails);
        SystemUser userByLogin = userService.getUserByLogin(user.getLogin());
        SystemUserDto systemUserDto = systemUserMapper.toDto(userByLogin);
        systemUserDto.setToken(token);
        return systemUserDto;
    }

    @GetMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }

    private String autologin(SystemUserDto user, UserDetails userDetails) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, user.getPassword(), userDetails.getAuthorities()
        );

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException e){
            throw new RuntimeException("Invalid username or password.");
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return jwtTokenUtil.generateToken(authenticationToken);
    }

    @PostMapping(value = "/register")
    public SystemUserDto register(@RequestBody @Validated(SystemUserDto.Registration.class) SystemUserDto user) {
        log.info(user);
        SystemUserDto systemUserDto = systemUserMapper.toDto(userService.createUser(systemUserMapper.toObject(user)));
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        String token = autologin(user, userDetails);
        systemUserDto.setToken(token);
        return systemUserDto;
    }
}
