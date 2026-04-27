package com.ra34.projecte2.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.dto.RemoveRolesRequestDTO;
import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.mapper.UserMapper;
import com.ra34.projecte2.model.Customer;
import com.ra34.projecte2.model.User;
import com.ra34.projecte2.repository.CustomerRepository;
import com.ra34.projecte2.repository.RoleRepository;
import com.ra34.projecte2.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserRequest request) {
        try {
            User user = userMapper.toEntity(request);
            user.setStatus(true);
            user.setDataCreated(new Date());
            user.setDataUpdated(new Date());
            User savedUser = userRepository.save(user);

            Customer customer = new Customer();
            customer.setFirstName(request.getFirstName());
            customer.setLastName(request.getLastName());
            customer.setPhone(request.getPhone());
            customer.setUser(savedUser);
            customer.setStatus(true);
            Timestamp now = new Timestamp(System.currentTimeMillis());
            customer.setDataCreated(now);
            customer.setDataUpdated(now);
            customerRepository.save(customer);

            savedUser.setCustomer(customer);

            return userMapper.toDto(savedUser);
        } catch (Exception e) {
            return null;
        }
    }

    public UserDTO getUserById(Long id) {
        Optional<User> found = userRepository.findById(id);
        if (found.isEmpty()) {
            return null;
        }
        return userMapper.toDto(found.get());
    }

    public User updatingUser(Long id, User user) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            User user_2 = existing.get();
            BeanUtils.copyProperties(user, user_2, "id", "dataUpdated");
            user_2.setDataUpdated(new Date());
            return userRepository.save(user_2);
        }
        return null;
    }

    @Transactional
    public UserDTO removeRolesFromUser(Long userId, RemoveRolesRequestDTO request) {
        Optional<User> found = userRepository.findById(userId);
        if (found.isEmpty()) {
            return null;
        }

        User user = found.get();

        user.getRoles().removeIf(role -> request.getRoleIds().contains(role.getId()));

        userRepository.save(user);

        return userMapper.toDto(user);
    }
}
