package com.hakathon.project.model;

import com.hakathon.project.model.enums.UserEnum;
import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class User {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String firstname;

  private String lastname;

  private LocalDate birthdate;

  @Enumerated(value = STRING)
  private UserEnum.Role role;

  @Enumerated(value = STRING)
  private UserEnum.Sex sex;

  @Enumerated(value = STRING)
  private UserEnum.AgeCategory ageCategory;

  private String password;

  private int age;

  private String cin;

  private String image;

  @OneToMany
  private List<User> childs;
}
