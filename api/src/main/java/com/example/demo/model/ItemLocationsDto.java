package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Created by dzni0816 on 21.12.2016.
 */
@Getter
@Setter
public class ItemLocationsDto implements Serializable {

    private String id;
    private LocationsDto location;
    private ItemDto item;
}
