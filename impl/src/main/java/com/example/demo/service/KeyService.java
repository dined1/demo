package com.example.demo.service;

import com.example.demo.model.KeySet;

public interface KeyService {
    KeySet getKeys(String id);

    KeySet createKeySet(KeySet keySet);

    KeySet updateKeySet(KeySet keySet);
}
