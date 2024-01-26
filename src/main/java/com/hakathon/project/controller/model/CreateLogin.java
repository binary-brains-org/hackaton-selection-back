package com.hakathon.project.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateLogin {
  String lastname;
  String firstname;
  String password;
}
