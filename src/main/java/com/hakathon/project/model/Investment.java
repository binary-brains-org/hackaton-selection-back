package com.hakathon.project.model;

import com.hakathon.project.model.enums.InvestmentEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"investment\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Investment {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String comment;

  @Enumerated(value = STRING)
  private InvestmentEnum.Status status;

  private int price;

  private String name;
}
