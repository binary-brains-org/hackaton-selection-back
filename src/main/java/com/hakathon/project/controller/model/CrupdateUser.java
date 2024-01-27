package com.hakathon.project.controller.model;

import com.hakathon.project.model.enums.UserEnum;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CrupdateUser {
  String firstname;
  String lastname;
  LocalDate birthdate;
  UserEnum.Sex sex;
  String image;
  String cin;
  UserEnum.Role role;
  UserEnum.AgeCategory ageCategory;
  int age;
  String password;
}
