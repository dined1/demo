package com.example.demo.service;

import com.example.demo.model.KeySet;
import com.example.demo.model.KeySetDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KeyService {
    KeySet getKeys(String id);

    KeySet createKeySet(KeySet keySet);

    KeySet updateKeySet(KeySet keySet);

    Page<KeySet> getUserKeys(String userId, String direction, List<String> fields, int pageNumber, int pageSize);

    boolean secretExists(String id);

    KeySet getSecret(String secret, List<String> keys);

    void delete(String id);
}
