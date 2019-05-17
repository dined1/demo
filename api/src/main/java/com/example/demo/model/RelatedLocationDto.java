package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Admin on 07.05.2017.
 */

@Getter
@Setter
public class RelatedLocationDto {

    private String id;
    private String name;
    private LocationDto parentLocation;
    private CustomerDto customer;
}
