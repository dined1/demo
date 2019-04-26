/**
 * This file was generated by the JPA Modeler
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author dzni0816
 */
@Entity
@Getter
@Setter
@Transactional
public class Address implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic
    private String addressLine;

    @Basic
    private String city;

    @Basic
    private String country;

    @Basic
    private String postalCode;

    @Basic
    private String modifiedDate;

    @OneToMany(targetEntity = Customer.class, mappedBy = "address1")
    private List<Customer> customers1;

    @OneToMany(targetEntity = Location.class, mappedBy = "address")
    private List<Location> locations;

}
