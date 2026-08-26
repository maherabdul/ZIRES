package com.zanzibar.zires.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyID;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String companyName;

    private String country;

    private String investmentSector;

    private String website;

    private String companyStatus;

    public Investor() {
    }

    public Investor(Long companyID, User user, String companyName,
                    String country, String investmentSector,
                    String website, String companyStatus) {
        this.companyID = companyID;
        this.user = user;
        this.companyName = companyName;
        this.country = country;
        this.investmentSector = investmentSector;
        this.website = website;
        this.companyStatus = companyStatus;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setInvestmentSector(String investmentSector) {
        this.investmentSector = investmentSector;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }
}