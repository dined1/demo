package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Admin on 07.05.2017.
 */
@Entity
@Getter
@Setter
@Transactional
public class Location {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic
    private String name;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @ManyToOne(targetEntity = Address.class)
    private Address address;

    @OneToMany(targetEntity = RelatedLocation.class, mappedBy = "parentLocation", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<RelatedLocation> relatedLocations;

    @OneToMany(targetEntity = So.class, mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<So> so;
}
