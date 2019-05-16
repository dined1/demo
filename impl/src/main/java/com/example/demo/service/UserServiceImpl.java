package com.example.demo.service;

import com.example.demo.model.SystemUser;
import com.example.demo.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SystemUser getUser(String id){
        return (SystemUser) Hibernate.unproxy(userRepository.getOne(id));
    }

    @Override
    public SystemUser createUser(SystemUser user){
        return userRepository.save(user);
    }
}
