package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class Card implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Basic
    private String cardnumber;

    @Basic
    private String cvc;

    @Basic
    private String cardholder;

    @Basic
    private String expiration_date;

    @Basic
    private String sum;

    @Basic
    private String soid;
}
