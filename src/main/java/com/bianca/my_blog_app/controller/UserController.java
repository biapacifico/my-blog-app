package com.bianca.my_blog_app.controller;

import com.bianca.my_blog_app.entity.User;
import com.bianca.my_blog_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User createUser(@RequestBody @Valid User user){
        return userService.createUser(user);
    }

    @GetMapping("{id}")
    User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PutMapping("{id}")
    User updateUser(@PathVariable("id") Long id, @RequestBody @Valid User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}