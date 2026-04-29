package com.ra34.projecte2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.mapper.UserMapper;
import com.ra34.projecte2.model.Role;
import com.ra34.projecte2.model.User;
import com.ra34.projecte2.repository.RoleRepository;
import com.ra34.projecte2.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserRequest user) {
        try {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                return null;
            }
            User entity = userMapper.toEntity(user);
            User created = userRepository.save(entity);
            return userMapper.toDto(created);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Transactional
    public UserDTO updatingUser(Long id, UserRequest request) {
        Optional<User> existing = userRepository.findById(id);

        if (!existing.isPresent()) return null;

        User user = existing.get();

        if (request.getEmail() != null) user.setEmail(request.getEmail());
        if (request.getPassword() != null) user.setPassword(request.getPassword());
        user.setDataUpdated(new Date());

        if (user.getCustomer() != null) {
            if (request.getFirstName() != null) user.getCustomer().setFirstName(request.getFirstName());
            if (request.getLastName() != null) user.getCustomer().setLastName(request.getLastName());
            if (request.getPhone() != null) user.getCustomer().setPhone(request.getPhone());
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }

    @Transactional
    public UserDTO addRolesToUser(Long userId, List<Long> roleIds) {
        Optional<User> existing = userRepository.findById(userId);

        if (!existing.isPresent()) return null;

        User user = existing.get();

        for (Long roleId : roleIds) {
            Optional<Role> roleOpt = roleRepository.findById(roleId);

            if (!roleOpt.isPresent()) continue;

            Role role = roleOpt.get();

            if (!user.getRoles().contains(role)) {
                user.getRoles().add(role);
                role.getUsers().add(user);
            }
        }

        return userMapper.toDto(userRepository.save(user));
    }
}