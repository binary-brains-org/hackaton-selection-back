package com.hakathon.project.repository;

import com.hakathon.project.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentCategoryRepository extends JpaRepository<Investment, String> {
}
