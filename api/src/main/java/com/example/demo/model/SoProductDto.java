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
public class SoProductDto implements Serializable {

    private String id;
    private SoDto so;
    private List<ProductItemsDto> productItemses;
}
