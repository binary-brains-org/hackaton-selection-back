package com.hakathon.project.repository;

import com.hakathon.project.model.Wallet;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
  @Query("""
  SELECT w FROM Wallet w LEFT JOIN User u on w.user = u
  WHERE u.id = :user_id
""")
  Optional<Wallet> findWalletByUserId(@Param(value = "user_id")String userId);
}
