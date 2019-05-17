package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class AccountDto {

    private String id;
    private String name;
    private String accountNumber;
    private Currency currency;
    private BigDecimal balance;
    private PayUserDto user;
    private boolean enable = true;

}
