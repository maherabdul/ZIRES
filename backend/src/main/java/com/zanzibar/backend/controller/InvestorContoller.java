package com.zanzibar.backend.controller;

import com.zanzibar.backend.model.Investor;
import com.zanzibar.backend.service.InvestorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Investor")
public class InvestorContoller {
    @Autowired

    private InvestorServices investorServices;

    @PostMapping("/create")
    public Investor addInvestor(@RequestBody Investor investor) {
        return investorServices.createInvestor(investor);
    }

    @GetMapping("{id}")
    public Investor getInvestorById(@PathVariable Long id) {
        return investorServices.getInvestorById(id);
    }
}
