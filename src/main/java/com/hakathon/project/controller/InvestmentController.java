package com.hakathon.project.controller;

import com.hakathon.project.model.Investment;
import com.hakathon.project.model.Token;
import com.hakathon.project.service.InvestmentService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InvestmentController {
    private final InvestmentService investmentService;

    @PostMapping("/storeMoney")
    public Investment storeMoney(@RequestBody Investment investment, HttpSession httpSession){
        Token token = (Token) httpSession.getAttribute("Session");
        return investmentService.storeMoney(investment, token.getUserId());
    }

    @PostMapping("/transferMoney/{user_id}")
    public Investment transferMoney(@RequestBody Investment investment,@PathVariable String user_id,HttpSession httpSession){
        Token token = (Token) httpSession.getAttribute("Session");
        return investmentService.transferMoney(investment, token.getUserId(), user_id);
    }

    @PostMapping("/buy")
    public Investment buyProduct(@RequestBody Investment investment,HttpSession httpSession){
        Token token = (Token) httpSession.getAttribute("Session");
        return investmentService.buyProducts(investment, token.getUserId());
    }
}