package com.example.demo.controller;

import com.example.demo.mapper.KeySetMapper;
import com.example.demo.model.KeySet;
import com.example.demo.model.KeySetDto;
import com.example.demo.model.PageResult;
import com.example.demo.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/keys")
public class KeysController {

    private final KeyService keyService;
    private final KeySetMapper keySetMapper;

    @Autowired
    public KeysController(KeyService keyService, KeySetMapper keySetMapper) {
        this.keyService = keyService;
        this.keySetMapper = keySetMapper;
    }

    @GetMapping("/name")
    public String getName(){
        return "New name";
    }

    @GetMapping("/key/{id}")
    public KeySetDto getKey(@PathVariable String id){
        return keySetMapper.toDto(keyService.getKeys(id));
    }

    @GetMapping("/user/{userId}")
    public PageResult getUserKeys(@PathVariable String userId,
                                  @RequestParam(required = false, defaultValue = "ASC") String direction,
                                  @RequestParam(required = false, defaultValue = "id") List<String> fields,
                                  @RequestParam(required = false, defaultValue = "1") int pageNumber,
                                  @RequestParam(required = false, defaultValue = "10") int pageSize, Principal principal){
        Page<KeySet> userKeys = keyService.getUserKeys(userId, direction, fields, pageNumber, pageSize);
        return new PageResult(userKeys.getTotalElements(), userKeys.getNumber(),
                userKeys.getSize(), userKeys.getTotalPages(), userKeys.get().map(keySetMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PostMapping("/key")
    public KeySetDto createKeys(@RequestBody KeySetDto keySet){
        return keySetMapper.toDto(keyService.createKeySet(keySetMapper.toObject(keySet)));
    }

    @PutMapping("/key/{id}")
    public KeySetDto updateKeys(@RequestBody KeySetDto keySet, @PathVariable String id){
        return keySetMapper.toDto(keyService.updateKeySet(keySetMapper.toObject(keySet)));
    }

}
