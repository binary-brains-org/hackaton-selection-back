package com.hakathon.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"wallet\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Wallet {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private int eMoney;

  private int withdrawLimit;

  @OneToOne
  private User user;

  public int withdraw(int toWithdraw) {
    this.eMoney -= toWithdraw;
    this.withdrawLimit -= toWithdraw;
    return this.eMoney;
  }
}
