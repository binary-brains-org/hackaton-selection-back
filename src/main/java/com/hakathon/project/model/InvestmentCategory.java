package com.hakathon.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"investment_category\"")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InvestmentCategory {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String label;
}
