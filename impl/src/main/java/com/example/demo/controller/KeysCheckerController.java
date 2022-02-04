package com.example.demo.controller;

import com.example.demo.mapper.KeySetMapper;
import com.example.demo.model.KeySetDto;
import com.example.demo.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keys/checker")
public class KeysCheckerController {

    private final KeyService keyService;
    private final KeySetMapper keySetMapper;

    @Autowired
    public KeysCheckerController(KeyService keyService, KeySetMapper keySetMapper) {
        this.keyService = keyService;
        this.keySetMapper = keySetMapper;
    }

    @GetMapping("/exists/{id}")
    public boolean secretExists(@PathVariable String id){
        return keyService.secretExists(id);
    }

    @GetMapping("/secret/")
    public KeySetDto secretExists(@RequestParam String secret,
                                  @RequestParam List<String> keys){
        return keySetMapper.toDto(keyService.getSecret(secret, keys));
    }
}
