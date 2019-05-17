package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PayUserDto {

    private String id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date registered = new Date();
    private boolean enabled = true;
    private List<AccountDto> accounts;
}
