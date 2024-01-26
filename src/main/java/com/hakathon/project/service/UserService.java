package com.hakathon.project.service;

import com.hakathon.project.controller.exception.NotFoundException;
import com.hakathon.project.model.User;
import com.hakathon.project.model.enums.UserEnum;
import com.hakathon.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final WalletService walletService;

    public User crupdateUser(User user){
        User newUser = userRepository.save(user);
        int limit = 0;
        if(user.getAgeCategory() == UserEnum.AgeCategory.KIDS){
            limit = 500;
        } else if (user.getAgeCategory() == UserEnum.AgeCategory.TEEN) {
            limit = 1000;
        } else if (user.getAgeCategory() == UserEnum.AgeCategory.ADULT) {
            limit = 1500;
        }
        walletService.createWallet(user.getId(),0,limit);
        return newUser;
    }
    public User getUserById(String userId){
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundException("User with id:" + userId + " not found");
        });
    }
}
