/**
 * This file was generated by the JPA Modeler
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * @author dzni0816
 */
@Getter
@Setter
public class Itemdiscount implements Serializable {

    private String id;
    private Item item1;
    private Discountrule discountrule;
}
