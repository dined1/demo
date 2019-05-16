package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Admin on 07.05.2017.
 */

@Getter
@Setter
public class RelatedLocation {

    private String id;
    private String name;
    private Location parentLocation;
    private Customer customer;
}
