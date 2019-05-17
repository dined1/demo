package com.example.demo.mapper;

import com.example.demo.model.SystemUser;
import com.example.demo.model.SystemUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface SystemUserMapper {
    SystemUserMapper INSTANCE = Mappers.getMapper(SystemUserMapper.class);
    SystemUserDto toDto(SystemUser entity);
    SystemUser toObject(SystemUserDto dto);
}