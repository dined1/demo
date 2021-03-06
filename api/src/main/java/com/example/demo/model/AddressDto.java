/**
 * This file was generated by the JPA Modeler
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

/**
 * @author dzni0816
 */
@Getter
@Setter
public class AddressDto implements Serializable {

    private String id;
    private String addressLine;
    private String city;
    private String country;
    private String postalCode;
    private String modifiedDate;
    private List<CustomerDto> customers1;
    private List<LocationDto> locations;

}
