/**
 * This file was generated by the JPA Modeler
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Soproduct implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne(targetEntity = So.class)
    private So so;

    @OneToMany(targetEntity = ProductItems.class, mappedBy = "soproduct", cascade = CascadeType.REMOVE)
    private List<ProductItems> productItemses;
}
