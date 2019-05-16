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
 * Created by dzni0816 on 21.12.2016.
 */
@Entity
@Getter
@Setter
@Transactional
public class Locations implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic
    private String locationname;

    @OneToMany(targetEntity = ItemLocations.class, mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<ItemLocations> itemlocations;

}
