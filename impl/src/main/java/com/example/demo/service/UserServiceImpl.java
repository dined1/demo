package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.SystemUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public SystemUser getUser(String id){
        return (SystemUser) Hibernate.unproxy(userRepository.getOne(id));
    }

    @Override
    @Transactional
    public SystemUser createUser(SystemUser user){
        SystemUser userDb = userRepository.findByLogin(user.getLogin());
        if (userDb != null){
            throw new RuntimeException("User exists!");
        }
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm())){
            throw new RuntimeException("Password doesn't matches!");
        }
        String newPass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(newPass);

        Set<Role> roles = Stream.of(roleRepository.findById("1").orElseThrow(RuntimeException::new))
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public SystemUser getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
