package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class Card implements Serializable {

    private String id;
    private String cardnumber;
    private String cvc;
    private String cardholder;
    private String expiration_date;
    private String sum;
    private String soid;
}
