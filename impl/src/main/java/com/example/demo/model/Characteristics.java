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
 * Created by Admin on 17.12.2016.
 */
@Entity
@Getter
@Setter
@Transactional
public class Characteristics implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic
    private String Characteristic;

    @Basic
    private String CharacteristicValue;

    @OneToMany(targetEntity = ItemCharacteristic.class, mappedBy = "itemCharacteristic", cascade = CascadeType.REMOVE)
    private List<ItemCharacteristic> itemCharacteristic;

    @OneToMany(targetEntity = OrdItemCharacteristic.class, mappedBy = "ItemCharacteristic", cascade = CascadeType.REMOVE)
    private List<OrdItemCharacteristic> orditemCharacteristic;

}
