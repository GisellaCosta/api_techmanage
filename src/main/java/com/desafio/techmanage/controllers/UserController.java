package com.desafio.techmanage.controllers;

import com.desafio.techmanage.dtos.UserDTO;
import com.desafio.techmanage.forms.UserForm;
import com.desafio.techmanage.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserForm userform) {
        return ResponseEntity.ok(userService.adicionar(userform));
    }

}
