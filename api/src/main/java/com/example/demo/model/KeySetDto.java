package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"userId"}, allowSetters = true)
public class KeySetDto {

    private String id;
    private String userId;
    private String code;
    private List<String> keys;

}
