package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.12.2016.
 */
@Getter
@Setter
public class OrdItem implements Serializable {

    private String oid;
    private String name;
    private String type;
    private String description;
    private Float defMP;
    private Float defOTP;
    private String modifiedDate;
    private String locationDistribute;
    private Long parentId;
    private String status;
    private OrdItem parent;
    private List<OrdItem> child;
    private Long location;
    private Long orderedBy;
    private Long initialVersion;
    private List<OrdItem> ordItems = new ArrayList<>();
    private List<ProductItems> productItemses;
    private List<OrdItemDiscount> itemdiscounts;
    private List<OrdItemCharacteristic> itemCharacteristic;

}
