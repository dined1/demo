package com.example.demo.controller;


import com.example.demo.model.KeySet;
import com.example.demo.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KeysController {

    @Autowired
    private KeyService keyService;

    @GetMapping("/name")
    public String getName(){
        return "New name";
    }

    @GetMapping("/keys/{id}")
    public KeySet getKeys(@PathVariable String id){
        return keyService.getKeys(id);
    }

    @PostMapping("/keys")
    public KeySet createKeys(@RequestBody KeySet keySet){
        return keyService.createKeySet(keySet);
    }

    @PutMapping("/keys")
    public KeySet updateKeys(@RequestBody KeySet keySet){
        return keyService.updateKeySet(keySet);
    }

}
