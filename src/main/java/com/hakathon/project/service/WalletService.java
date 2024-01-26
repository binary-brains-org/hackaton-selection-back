package com.hakathon.project.service;

import com.hakathon.project.controller.exception.NotFoundException;
import com.hakathon.project.model.Wallet;
import com.hakathon.project.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {
  private final WalletRepository walletRepository;
  private final UserService userService;
  public Wallet createWallet(String userId,Integer eMoney,Integer limit){
    Wallet wallet = Wallet.builder()
            .user(userService.getUserById(userId))
            .eMoney(eMoney)
            .withdrawLimit(limit)
            .build();
    return walletRepository.save(wallet);
  }
  public Wallet getWalletByUserId(String userId) {
    return walletRepository.findWalletByUserId(userId).orElseThrow(() -> {
      throw new NotFoundException("Wallet with user id:" + userId + " not found");
    });
  }

  public Wallet withdrawBalance(String userId, int toWithdraw) {
    Wallet wallet = getWalletByUserId(userId);
    wallet.withdraw(toWithdraw);
    return walletRepository.save(wallet);
  }
}
