package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Created by dzni0816 on 21.12.2016.
 */
@Getter
@Setter
public class ItemLocations implements Serializable {

    private String id;
    private Locations location;
    private Item item;
}
