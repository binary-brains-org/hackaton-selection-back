package com.hakathon.project.service;

import com.hakathon.project.controller.exception.NotFoundException;
import com.hakathon.project.model.User;
import com.hakathon.project.model.enums.UserEnum;
import com.hakathon.project.repository.UserRepository;
import java.util.Base64;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final WalletService walletService;

    public User crupdateUser(User user){
        user.setId(UUID.randomUUID().toString());
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

    public User getByFirstNameAndLastName(String firstname,String lastname){
        return userRepository.findByFirstnameAndLastname(firstname,lastname);
    }
    public boolean authenticate(String firstname, String lastname, String password){
        User user = userRepository.findByFirstnameAndLastname(firstname,lastname);
        return user != null && user.getPassword().equals(password);
    }

        public User uploadImage(byte[] bytes, String userId) {
            String base64File = Base64.getEncoder().encodeToString(bytes);
            User user = getUserById(userId);
            user.setImage(base64File);
            return userRepository.save(user);
        };

    public List<User> getParentChild(String userId) {
        User parent = getUserById(userId);
        return parent.getChilds();
    }
}
