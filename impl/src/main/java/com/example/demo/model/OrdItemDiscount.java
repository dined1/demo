package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Admin on 17.12.2016.
 */
@Entity
@Getter
@Setter
@Transactional
public class OrdItemDiscount implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne(targetEntity = OrdItem.class)
    private OrdItem ordItem;

    @ManyToOne(targetEntity = Discountrule.class)
    private Discountrule discountrule;
}
