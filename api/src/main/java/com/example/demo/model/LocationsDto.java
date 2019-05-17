package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dzni0816 on 21.12.2016.
 */
@Getter
@Setter
public class LocationsDto implements Serializable {

    private String id;
    private String locationname;
    private List<ItemLocationsDto> itemlocations;

}
