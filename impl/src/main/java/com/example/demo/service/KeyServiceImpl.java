package com.example.demo.service;

import com.example.demo.model.KeySet;
import com.example.demo.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
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
            throw new EntityExistsException(String.format("Key with id '%s' exists", keySet.getId()));
        }
        return keyRepository.save(keySet);
    }

    @Override
    public KeySet updateKeySet(KeySet keySet) {
        return keyRepository.save(keySet);
    }

    @Override
    public Page<KeySet> getUserKeys(String userId, String direction, List<String> fields, int pageNumber, int pageSize) {
        Pageable pageable = createPageable(direction, fields, pageNumber, pageSize);
        return keyRepository.findAllByCreatedBy_Id(userId, pageable);
    }

    private Pageable createPageable(String direction, List<String> fields, int pageNumber, int pageSize) {
        Sort sort = new Sort(Sort.Direction.valueOf(direction), fields);
        return PageRequest.of(pageNumber-1, pageSize, sort);
    }
}
