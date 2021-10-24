package com.gabrielkuhn.user.controller;

import com.gabrielkuhn.user.entity.User;
import com.gabrielkuhn.user.service.UserService;
import com.gabrielkuhn.user.representation.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public UserResponse getUserWithDepartment(@PathVariable Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUser(userId);
    }
}
