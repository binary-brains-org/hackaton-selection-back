package com.hakathon.project.controller.mapper;

import com.hakathon.project.controller.model.UserToken;
import com.hakathon.project.model.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AuthMapper {
  public UserToken toRest(User user) {
    return UserToken.builder()
        .userId(user.getId())
        .build();
  }
}
