package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SystemUserDto {

    private String id;
    private String login;
    @JsonIgnore
    private String password;
    private String passwordConfirm;
    @JsonIgnore
    private Set<RoleDto> roles;

}
