package com.ra34.projecte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.dto.ErrorDTO;
import com.ra34.projecte2.dto.RemoveRolesRequestDTO;
import com.ra34.projecte2.dto.RoleRequestDTO;
import com.ra34.projecte2.dto.UserDTO;
import com.ra34.projecte2.dto.UserRequest;
import com.ra34.projecte2.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    // POST /api/user — crea un usuari nou (Integrant 1)
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserRequest user) {
        UserDTO created = userService.createUser(user);

        if (created == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(400, "Ja existeix un usuari amb aquest email o error en la creació."));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /api/user/{id} — modifica la informació d'un usuari i el seu customer (Integrant 2 - 2c)
    @PatchMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        UserDTO updated = userService.updatingUser(id, request);

        if (updated == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(404, "Usuari no trobat amb id: " + id));
        }

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // GET /api/users — retorna tots els usuaris (Integrant 2 - 2d)
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    // POST /api/user/{id}/rols — afegeix rols a un usuari (Integrant 2 - 5a)
    @PostMapping("/user/{id}/rols")
    public ResponseEntity<?> addRolesToUser(@PathVariable Long id, @RequestBody RemoveRolesRequestDTO request) {
        UserDTO updated = userService.addRolesToUser(id, request.getRoleIds());

        if (updated == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(404, "Usuari no trobat amb id: " + id));
        }

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}