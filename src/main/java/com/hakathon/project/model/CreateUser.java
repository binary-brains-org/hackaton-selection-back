package com.hakathon.project.model;

import com.hakathon.project.model.enums.UserEnum;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@Data
public class CreateUser {
    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    @Enumerated(value = STRING)
    private UserEnum.Sex sex;

    private String password;

    private String cin;

    private String image;
}
