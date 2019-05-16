package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SystemUser {

    private String id;
    private String login;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;

}