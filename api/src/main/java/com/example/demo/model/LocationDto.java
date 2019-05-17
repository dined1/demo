package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Created by Admin on 07.05.2017.
 */
@Getter
@Setter
public class LocationDto {

    private String id;
    private String name;
    private CustomerDto customer;
    private AddressDto address;
    private List<RelatedLocationDto> relatedLocations;
    private List<SoDto> so;
}
