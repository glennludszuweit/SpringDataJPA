package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.User;
import com.pluralsight.conference.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(User user) {
        userService.save(user);
        return user;
    }

    @GetMapping
    public User getUser(@RequestParam String firstname,
                        @RequestParam String lastname,
                        @RequestParam Integer age) {
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }
}
