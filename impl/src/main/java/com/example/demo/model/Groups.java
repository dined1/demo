/**
 * This file was generated by the JPA Modeler
 */
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
public class Groups implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic(optional = false)
    private String name;

    @OneToMany(targetEntity = Itemgroup.class, mappedBy = "groups1", cascade = CascadeType.REMOVE)
    private List<Itemgroup> itemgroups1;

}
