package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class Account {

    private String id;
    private String name;
    private String accountNumber;
    private Currency currency;
    private BigDecimal balance;
    private PayUser user;
    private boolean enable = true;

}
