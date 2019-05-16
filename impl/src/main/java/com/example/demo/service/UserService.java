package com.example.demo.service;

import com.example.demo.model.SystemUser;

public interface UserService {

    SystemUser getUser(String id);

    SystemUser createUser(SystemUser user);
}
