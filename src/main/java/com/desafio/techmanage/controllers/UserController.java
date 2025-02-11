package com.desafio.techmanage.controllers;

import com.desafio.techmanage.models.User;
import com.desafio.techmanage.vo.UserVO;
import com.desafio.techmanage.forms.UserForm;
import com.desafio.techmanage.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity<UserVO> addUser(@Valid @RequestBody UserForm userform) {
        return ResponseEntity.ok(userService.addUser(userform));
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<UserVO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());

    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<UserVO> findUsersById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUsersById(id));

    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<UserVO> updateUsersById(@PathVariable Long id, @Valid @RequestBody UserForm userform) {
        return ResponseEntity.ok(userService.updateUsersById(id, userform));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserVO> deleteUsersById(@PathVariable Long id){

        userService.deleteUsersById(id);

        return ResponseEntity.ok().build();
    }


}
