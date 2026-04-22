package com.ra34.projecte2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.mapper.UserMapper;
import com.ra34.projecte2.model.User;
import com.ra34.projecte2.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserRequest user) {
        try {
            User entity = userMapper.toEntity(user);
            User created = userRepository.save(entity);
            return userMapper.tDto(created);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
