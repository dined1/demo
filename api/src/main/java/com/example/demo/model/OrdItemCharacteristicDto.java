package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Created by Admin on 17.12.2016.
 */

@Getter
@Setter
public class OrdItemCharacteristicDto implements Serializable {

    private String id;
    private CharacteristicsDto ItemCharacteristic;
    private OrdItemDto ordItem;

}
