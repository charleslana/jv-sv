package com.example.jv_sv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jv_sv.model.dto.UserDTO;
import com.example.jv_sv.model.dto.UserUpdateDTO;
import com.example.jv_sv.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto) {
        UserDTO createdUser = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @PathVariable String id, @RequestBody UserUpdateDTO dto) {
        Long longId;
        try {
            longId = Long.valueOf(id);
            dto.setUserId(longId);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }
        UserDTO updatedUser = service.update(dto);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@Valid @PathVariable String id) {
        Long longId;
        try {
            longId = Long.valueOf(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }
        UserDTO user = service.getByUserId(longId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.getAll();
        return ResponseEntity.ok(users);
    }
}