package com.hakathon.project.controller;

import com.hakathon.project.controller.mapper.UserMapper;
import com.hakathon.project.model.User;
import com.hakathon.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PutMapping("/createUser")
    public User crupdateUser(@RequestBody User user){
        return userService.crupdateUser(userMapper.toDomain(user));
    }

    @GetMapping("user/{user_id}")
    public Optional<User> getUser(@PathVariable String user_id){
        return userService.getUserById(user_id);
    }

}
