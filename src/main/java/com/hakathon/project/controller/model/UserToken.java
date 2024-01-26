package com.hakathon.project.controller.model;

import lombok.Builder;

@Builder
public class UserToken {
  String userId;
  String token;
}
