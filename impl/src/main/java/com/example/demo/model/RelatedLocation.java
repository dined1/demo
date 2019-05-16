package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Admin on 07.05.2017.
 */
@Entity
@Transactional
public class RelatedLocation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic
    private String name;

    @ManyToOne(targetEntity = Location.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Location parentLocation;

    @ManyToOne(targetEntity = Customer.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Customer customer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
