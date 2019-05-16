package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.12.2016.
 */
@Entity
@Getter
@Setter
@Transactional
public class OrdItem implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String oid;

    @Basic
    private String name;

    @Basic
    private String type;

    @Basic
    private String description;

    @Basic
    private Float defMP;

    @Basic
    private Float defOTP;

    @Basic
    private String modifiedDate;

    @Basic
    private String locationDistribute;

    @Basic
    private Long parentId;

    @Basic
    private String status;

    @ManyToOne
    private OrdItem parent;

    @OneToMany(mappedBy = "parent")
    private List<OrdItem> child;

    @Basic
    private Long location;

    @Basic
    private Long orderedBy;

    @Basic
    private Long initialVersion;

    @OneToMany(targetEntity = OrdItem.class, mappedBy = "parent", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<OrdItem> ordItems = new ArrayList<>();

    @OneToMany(targetEntity = ProductItems.class, mappedBy = "ordItem", cascade = CascadeType.REMOVE)
    private List<ProductItems> productItemses;

    @OneToMany(targetEntity = OrdItemDiscount.class, mappedBy = "discountrule", cascade = CascadeType.REMOVE)
    private List<OrdItemDiscount> itemdiscounts;

    @OneToMany(targetEntity = OrdItemCharacteristic.class, mappedBy = "ordItem", cascade = CascadeType.REMOVE)
    private List<OrdItemCharacteristic> itemCharacteristic;

}
