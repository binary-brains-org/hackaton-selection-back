package com.hakathon.project.repository;

import com.hakathon.project.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByFirstnameAndLastname(String firstname, String lastname);
}
