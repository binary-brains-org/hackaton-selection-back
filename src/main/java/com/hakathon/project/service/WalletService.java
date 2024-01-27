package com.hakathon.project.service;

import com.hakathon.project.controller.exception.BadRequestException;
import com.hakathon.project.controller.exception.NotFoundException;
import com.hakathon.project.model.User;
import com.hakathon.project.model.Wallet;
import com.hakathon.project.repository.UserRepository;
import com.hakathon.project.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {
  private final WalletRepository walletRepository;
  private final UserRepository userRepository;

  public Wallet saveWallet(Wallet wallet){
    return walletRepository.save(wallet);
  }

  public Wallet createWallet(String userId,Integer eMoney,Integer limit){
    Wallet wallet = Wallet.builder()
            .user(getUserById(userId))
            .eMoney(eMoney)
            .withdrawLimit(limit)
            .build();
    return walletRepository.save(wallet);
  }

  private User getUserById(String userId){
    return userRepository.findById(userId).orElseThrow(() -> {
      throw new NotFoundException("User with id:" + userId + " not found");
    });
  }

  public Wallet getWalletByUserId(String userId) {
    return walletRepository.findWalletByUserId(userId).orElseThrow(() -> {
      throw new NotFoundException("Wallet with user id:" + userId + " not found");
    });
  }

  public Wallet withdrawBalance(String userId, int toWithdraw) {
    Wallet wallet = getWalletByUserId(userId);
    if(wallet.getEMoney() < toWithdraw) {
      throw new BadRequestException("Withdraw is superior of balance");
    }
    wallet.withdraw(toWithdraw);
    return walletRepository.save(wallet);
  }

  public Wallet depositBalance(String userId, int toDeposit) {
    Wallet wallet = getWalletByUserId(userId);
    if(toDeposit <= 0) {
      throw new BadRequestException("Deposit is negative");
    }
    wallet.deposit(toDeposit);
    return walletRepository.save(wallet);
  }
}
