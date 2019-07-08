package com.example.demo.model;

import com.example.demo.model.validation.CheckPassword;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@CheckPassword(groups = SystemUserDto.Registration.class, message = "Password doesn't matches")
@JsonIgnoreProperties(value = {"password", "roles"}, allowSetters = true)
public class SystemUserDto {

    public interface Registration extends Default {}

    private String id;
    @NotBlank(message = "Login shouldn't be empty")
    private String login;
    @NotBlank(message = "Password shouldn't be empty")
    private String password;
    private String passwordConfirm;
    private Set<RoleDto> roles;
    private String token;

}
