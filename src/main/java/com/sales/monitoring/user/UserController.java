package com.sales.monitoring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
        UserModel createdUser = userService.createUser(userModel);

        return createdUser;
    }

    @GetMapping("/{username}")
    public UserModel getByUsername(@RequestParam String username) {
        UserModel user = userService.getByUsername(username);

        return user;
    };
}

