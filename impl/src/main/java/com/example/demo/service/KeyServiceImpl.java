package com.example.demo.service;

import com.example.demo.model.KeySet;
import com.example.demo.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;

@Service
public class KeyServiceImpl implements KeyService {

    @Autowired
    private KeyRepository keyRepository;

    @Override
    public KeySet getKeys(String id){
        return keyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No value present"));
    }

    @Override
    public KeySet createKeySet(KeySet keySet) {
        if (keyRepository.existsById(keySet.getId())){
            throw new EntityExistsException("No such entity");
        }
        return keyRepository.save(keySet);
    }

    @Override
    public KeySet updateKeySet(KeySet keySet) {
        return keyRepository.save(keySet);
    }

}
