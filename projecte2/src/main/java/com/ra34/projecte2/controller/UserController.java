package com.ra34.projecte2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> postMethodName(@RequestBody UserRequest user) {
        UserDTO created = userService.createUser(user);

        if (created == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    
}
