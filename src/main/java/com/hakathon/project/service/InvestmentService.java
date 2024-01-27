package com.hakathon.project.service;

import com.hakathon.project.controller.exception.BadRequestException;
import com.hakathon.project.controller.exception.ForbiddenException;
import com.hakathon.project.controller.model.CreateInvestment;
import com.hakathon.project.model.Investment;
import com.hakathon.project.model.InvestmentCategory;
import com.hakathon.project.model.Wallet;
import com.hakathon.project.model.enums.UserEnum;
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
    private final UserService userService;

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
    public Investment storeMoney(Investment investment,String userId){
        if(userService.getUserById(userId).getAgeCategory() == UserEnum.AgeCategory.ADULT){
            Wallet wallet = walletService.getWalletByUserId(userId);
            wallet.setEMoney(wallet.getEMoney()+investment.getPrice());
            walletService.saveWallet(wallet);
            investmentRepository.save(investment);
            return investment;
        }
        throw new ForbiddenException("Only adults are allowed to store money");
    }

    public Investment transferMoney(Investment investment,String userParent,String userKid){
        if(userService.getUserById(userKid).getAgeCategory() == UserEnum.AgeCategory.ADULT){
            throw new BadRequestException("You cant transfer money to an another adult");
        }
        Wallet parent = walletService.getWalletByUserId(userParent);
        Wallet kid = walletService.getWalletByUserId(userKid);
        parent.setEMoney(parent.getEMoney() - investment.getPrice());
        kid.setEMoney(kid.getEMoney() + investment.getPrice());
        walletService.saveWallet(parent);
        walletService.saveWallet(kid);
        investmentRepository.save(investment);
        return investment;
    }

    public Investment buyProducts(Investment investment,String userId){
        Wallet wallet = walletService.getWalletByUserId(userId);
        if(investment.getPrice() > wallet.getEMoney() || wallet.getEMoney() == 0 || wallet.getWithdrawLimit() == 0 ||
                investment.getPrice() > wallet.getWithdrawLimit()){
            throw new ForbiddenException("You cannot buy things anymore");
        }
        wallet.setWithdrawLimit(wallet.getWithdrawLimit() - investment.getPrice());
        wallet.setEMoney(wallet.getEMoney() - investment.getPrice());
        walletService.saveWallet(wallet);
        investmentRepository.save(investment);
        return investment;
    }
}
