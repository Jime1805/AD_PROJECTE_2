package com.ra34.projecte2.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.model.User;
import com.ra34.projecte2.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User updatingUser(Long id, User user){ //Integrant 2 ex: 2.c
        Optional<User> existing = userRepository.findById(null);
        if (existing.isPresent()) {
            User user_2 = existing.get();
            BeanUtils.copyProperties(user, user_2, "id", "dataUpdated");
            user_2.setDataUpdated(new Date());
            return userRepository.save(user_2);
        }
        return null;
    }
}
