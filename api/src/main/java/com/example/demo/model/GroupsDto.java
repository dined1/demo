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
public class GroupsDto implements Serializable {

    private String id;
    private String name;
    private List<ItemGroupDto> itemgroups1;

}
