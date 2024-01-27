package com.hakathon.project.controller;

import com.hakathon.project.controller.mapper.UserMapper;
import com.hakathon.project.controller.model.CrupdateUser;
import com.hakathon.project.model.User;
import com.hakathon.project.service.UserService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PutMapping("/createUser")
    public User crupdateUser(@RequestBody CrupdateUser user){
        return userService.crupdateUser(userMapper.toDomain(user));
    }

    @GetMapping("/user/{user_id}/child")
    public List<com.hakathon.project.controller.model.User> getParentChild(
        @PathVariable(name = "user_id")String parentId) {
        return userService.getParentChild(parentId).stream()
            .map(userMapper::toRest)
            .collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("/user/{user_id}")
    public com.hakathon.project.controller.model.User getUser(@PathVariable String user_id){
        return userMapper.toRest(userService.getUserById(user_id));
    }

}
