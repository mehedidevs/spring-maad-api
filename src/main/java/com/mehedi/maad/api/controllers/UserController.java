package com.mehedi.maad.api.controllers;

import com.mehedi.maad.api.entities.User;
import com.mehedi.maad.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(
            @RequestBody User user
    ) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {

        List<User> users = userService.getAllUser();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }


}
