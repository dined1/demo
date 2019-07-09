package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeySet {

    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SystemUser.class)
    private SystemUser createdBy;
    private String code;
    @ElementCollection
    private List<String> keys;

}
