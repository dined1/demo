package com.example.demo.mapper;

import com.example.demo.model.KeySet;
import com.example.demo.model.KeySetDto;

public interface KeySetMapper {

    KeySetDto toDto(KeySet entity);
    KeySet toObject(KeySetDto dto);

}
