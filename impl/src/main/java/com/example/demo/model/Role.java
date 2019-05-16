package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Getter
@Setter
@Transactional
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<SystemUser> systemUsers;

    public Role(String id, String name){
        this.id = id;
        this.name = name;
    }
}
