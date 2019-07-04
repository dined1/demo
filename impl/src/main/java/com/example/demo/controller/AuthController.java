package com.example.demo.controller;

import com.example.demo.mapper.SystemUserMapper;
import com.example.demo.model.AuthToken;
import com.example.demo.model.Constants;
import com.example.demo.model.SystemUserDto;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @PostMapping(value = "/login")
    public AuthToken generateToken(@RequestBody SystemUserDto user) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        log.info(userDetails);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, user.getPassword(), userDetails.getAuthorities()
        );

        authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(authenticationToken);
        return new AuthToken(token);
    }

    @PostMapping(value = "/register")
    public SystemUserDto register(@RequestBody SystemUserDto user) {
        log.info(user);
        return systemUserMapper.toDto(userService.createUser(systemUserMapper.toObject(user)));
    }

    @GetMapping(value = "/expDate")
    public Date GetExpDate(@PathVariable String token){
        token = token.replace(Constants.TOKEN_PREFIX, "");
        return jwtTokenUtil.getExpirationDateFromToken(token);
    }

}
