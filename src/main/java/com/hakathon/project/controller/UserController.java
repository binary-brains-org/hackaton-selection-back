package com.hakathon.project.controller;

import com.hakathon.project.controller.mapper.UserMapper;
import com.hakathon.project.controller.model.CrupdateUser;
import com.hakathon.project.model.LoginUser;
import com.hakathon.project.model.Token;
import com.hakathon.project.model.User;
import com.hakathon.project.service.UserService;

import java.util.Base64;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/postImage")
    public User postImage(@RequestBody byte[] image, HttpSession httpSession){
        Token token = (Token) httpSession.getAttribute("Session");
        try {
            String data = Base64.getEncoder().encodeToString(image);
            User user = userService.getUserById(token.getUserId());
            user.setImage(data);
            userService.crupdateUser(user);
            System.out.println("Image saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
        return userService.getUserById(token.getUserId());
    }

    @PostMapping("/loginUser")
    public Token login(@RequestBody LoginUser loginUser, HttpSession httpSession){
        System.out.println(userService.authenticate(loginUser.getFirstname(), loginUser.getLastname(), loginUser.getPassword()));
        System.out.println(userService.authenticate(loginUser.getFirstname(), loginUser.getLastname(), loginUser.getPassword()));
        if(userService.authenticate(loginUser.getFirstname(), loginUser.getLastname(), loginUser.getPassword())){
            Token newOne = Token.builder()
                    .userId(userService.getByFirstNameAndLastName(loginUser.getFirstname(), loginUser.getLastname()).getId())
                    .token(UUID.randomUUID().toString())
                    .build();
            httpSession.setAttribute("Session", newOne);
            return newOne;
        } else{
            return Token.builder().build();
        }
    }

}
