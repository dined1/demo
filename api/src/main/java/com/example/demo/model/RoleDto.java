package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {

    private String id;
    private String name;
    private List<SystemUserDto> systemUsers;

    public RoleDto(String id, String name){
        this.id = id;
        this.name = name;
    }
}
