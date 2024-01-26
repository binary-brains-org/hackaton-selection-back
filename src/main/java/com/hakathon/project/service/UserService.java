package com.hakathon.project.service;

import com.hakathon.project.model.User;
import com.hakathon.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User crupdateUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> getUserById(String userId){
        return userRepository.findById(userId);
    }
}
