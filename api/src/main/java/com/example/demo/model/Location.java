package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Created by Admin on 07.05.2017.
 */
@Getter
@Setter
public class Location {

    private String id;
    private String name;
    private Customer customer;
    private Address address;
    private List<RelatedLocation> relatedLocations;
    private List<So> so;
}
