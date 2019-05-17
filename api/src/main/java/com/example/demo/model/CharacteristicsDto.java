package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 17.12.2016.
 */
@Getter
@Setter
public class CharacteristicsDto implements Serializable {

    private String id;
    private String Characteristic;
    private String CharacteristicValue;
    private List<ItemCharacteristicDto> itemCharacteristic;
    private List<OrdItemCharacteristicDto> orditemCharacteristic;

}
