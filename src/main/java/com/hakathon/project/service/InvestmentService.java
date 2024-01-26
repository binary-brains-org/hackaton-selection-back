package com.hakathon.project.service;

import com.hakathon.project.model.Investment;
import com.hakathon.project.model.Wallet;
import com.hakathon.project.repository.InvestmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvestmentService {
    private final InvestmentRepository investmentRepository;
    private final WalletService walletService;
    
}
