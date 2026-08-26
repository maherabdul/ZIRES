package com.zanzibar.zires.service;

import com.zanzibar.zires.entity.Investor;
import com.zanzibar.zires.repository.InvestorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public Investor createInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Optional<Investor> getInvestorById(Long id) {
        return investorRepository.findById(id);
    }

    public Investor updateInvestor(Long id, Investor investorDetails) {

        Investor investor = investorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));

        investor.setUser(investorDetails.getUser());
        investor.setCompanyName(investorDetails.getCompanyName());
        investor.setCountry(investorDetails.getCountry());
        investor.setInvestmentSector(investorDetails.getInvestmentSector());
        investor.setWebsite(investorDetails.getWebsite());
        investor.setCompanyStatus(investorDetails.getCompanyStatus());

        return investorRepository.save(investor);
    }

    public void deleteInvestor(Long id) {
        investorRepository.deleteById(id);
    }
}