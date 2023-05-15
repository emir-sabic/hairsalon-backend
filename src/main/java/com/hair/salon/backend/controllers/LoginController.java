package com.hair.salon.backend.controllers;

import com.hair.salon.backend.models.UserDto;
import com.hair.salon.backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {
    private final UserService userService;

    LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserDto getUser(@PathVariable long id) {
        return userService.getUser(id);
    }
}

