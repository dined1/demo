package com.example.demo.mapper;

import com.example.demo.model.KeySet;
import com.example.demo.model.KeySetDto;
import com.example.demo.model.SystemUser;
import com.example.demo.repository.KeyRepository;
import com.example.demo.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeySetMapperImpl implements KeySetMapper {

    private final UserRepository userRepository;

    @Autowired
    public KeySetMapperImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public KeySetDto toDto(KeySet entity) {
        if ( entity == null ) {
            return null;
        }
        KeySetDto keySetDto = new KeySetDto();
        keySetDto.setId( entity.getId() );
        List<String> list = entity.getKeys();
        if ( list != null ) {
            keySetDto.setKeys(new ArrayList<>(list) );
        }
        keySetDto.setUserId(entity.getCreatedBy().getId());

        return keySetDto;
    }

    @Override
    public KeySet toObject(KeySetDto dto) {
        if ( dto == null ) {
            return null;
        }

        KeySet keySet = new KeySet();

        keySet.setId( dto.getId() );
        List<String> list = dto.getKeys();
        if ( list != null ) {
            keySet.setKeys(new ArrayList<>(list) );
        }
        keySet.setCreatedBy((SystemUser) Hibernate.unproxy(userRepository.getOne(dto.getUserId())));

        return keySet;
    }
}
