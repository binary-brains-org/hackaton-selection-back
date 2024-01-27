package com.hakathon.project.controller;

import com.hakathon.project.model.Investment;
import com.hakathon.project.model.Wallet;
import com.hakathon.project.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @GetMapping("/getWallet/{user_id}")
    public Wallet getWalletById(@PathVariable String user_id){
        return walletService.getWalletByUserId(user_id);
    }
}
