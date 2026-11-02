package com.zanzibar.backend.service;

import com.zanzibar.backend.model.Investor;
import com.zanzibar.backend.repository.InvestorRepository;
import com.zanzibar.backend.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvestorServices {

    @Autowired
    private InvestorRepository investorRepository;

    public Investor createInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    public Investor findInvestorById(Long id) {
        return investorRepository.findById(id).orElse(null);
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor updateInvestor(Investor investor,Long id) {
        Investor existingInvestor = investorRepository.findById(id).orElse(null);

        if (existingInvestor != null) {
            existingInvestor.setInvestorName(investor.getInvestorName());

            existingInvestor.setInvestorProfile(investor.getInvestorProfile());

            existingInvestor.setHireEmployees(investor.getHireEmployees());

            existingInvestor.setPostJobs(investor.getPostJobs());

            existingInvestor.setScheduleInterview(investor.getScheduleInterview());

            existingInvestor.setInvestorProfile(investor.getInvestorProfile());

            return investorRepository.save(existingInvestor);
        }
        return null;
    }

    public void deleteInvestor(Investor investor) {
        investorRepository.delete(investor);
    }

}
