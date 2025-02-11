package com.desafio.techmanage.controllers;

import com.desafio.techmanage.vo.UserVO;
import com.desafio.techmanage.forms.UserForm;
import com.desafio.techmanage.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity<UserVO> adicionar(@Valid @RequestBody UserForm userform) {
        return ResponseEntity.ok(userService.adicionar(userform));
    }


}
