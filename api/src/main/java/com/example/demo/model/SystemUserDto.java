package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"password", "roles"}, allowSetters = true)
public class SystemUserDto {

    private String id;
    private String login;
    private String password;
    private String passwordConfirm;
    private Set<RoleDto> roles;

}
