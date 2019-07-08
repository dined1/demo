package com.example.demo.service;

import com.example.demo.model.KeySet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KeyService {
    KeySet getKeys(String id);

    KeySet createKeySet(KeySet keySet);

    KeySet updateKeySet(KeySet keySet);

    Page<KeySet> getUserKeys(String userId, String direction, List<String> fields, int pageNumber, int pageSize);
}
