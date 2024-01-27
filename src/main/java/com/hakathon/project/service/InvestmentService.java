package com.hakathon.project.service;

import com.hakathon.project.controller.model.CreateInvestment;
import com.hakathon.project.model.Investment;
import com.hakathon.project.model.InvestmentCategory;
import com.hakathon.project.repository.InvestmentRepository;
import com.hakathon.project.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class InvestmentService {
    private final InvestmentRepository investmentRepository;
    private final WalletService walletService;
    private final WalletRepository walletRepository;

    public Investment crupdateCategory(CreateInvestment createInvestment){
        var investment = Investment.builder()
            .photo(createInvestment.getImage())
            .price(createInvestment.getPrice())
            .status(createInvestment.getStatus())
            .comment(createInvestment.getComment())
            .name(createInvestment.getName())
            .investmentCategory(createInvestment.getCategory())
            .build();
        return investmentRepository.save(investment);
    }
}
