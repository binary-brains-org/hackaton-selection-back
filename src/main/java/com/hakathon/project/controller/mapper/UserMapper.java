package com.hakathon.project.controller.mapper;

import com.hakathon.project.model.User;
import com.hakathon.project.model.enums.UserEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;

@Component
@AllArgsConstructor
public class UserMapper {

    public User toDomain(User user) {
        int age = (Period.between(user.getBirthdate(), LocalDate.now())).getYears();
        User newUser = new User();
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setBirthdate(user.getBirthdate());
        newUser.setSex(user.getSex());
        newUser.setCin( user.getCin() == null ? null : user.getCin());
        newUser.setRole(age < 18 ? UserEnum.Role.CHILD: UserEnum.Role.PARENT);
        if(age >= 6 && age < 12){
            newUser.setAgeCategory(UserEnum.AgeCategory.KIDS);
        } else if (age >= 12 && age < 18) {
            newUser.setAgeCategory(UserEnum.AgeCategory.TEEN);
        } else if (age >= 18) {
            newUser.setAgeCategory(UserEnum.AgeCategory.ADULT);
        }
        newUser.setAge(age);
        newUser.setImage(null);
        newUser.setPassword(user.getPassword());
        return newUser;
    }
}