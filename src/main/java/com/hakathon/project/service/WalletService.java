package com.hakathon.project.service;

import com.hakathon.project.model.Wallet;
import com.hakathon.project.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {
  private final WalletRepository walletRepository;

  public Wallet getWalletByUserId(String userId) {
    return walletRepository.findWalletByUserId(userId).get();
  }

  public Wallet withdrawBalance(String userId, int toWithdraw) {
    Wallet wallet = getWalletByUserId(userId);
    wallet.withdraw(toWithdraw);
    return walletRepository.save(wallet);
  }
}
