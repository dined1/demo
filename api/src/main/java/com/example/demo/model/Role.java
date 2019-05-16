package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Role {

    private String id;
    private String name;
    private List<SystemUser> systemUsers;

    public Role(String id, String name){
        this.id = id;
        this.name = name;
    }
}
