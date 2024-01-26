package com.hakathon.project.service.auth;

import com.hakathon.project.model.User;
import com.hakathon.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
  private final UserRepository userRepository;

  private final User getUserById(String userId) {

  }
}
