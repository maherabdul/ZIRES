package com.zanzibar.zires.entity;

import jakarta.persistence.*;

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

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInvestmentSector() {
        return investmentSector;
    }

    public void setInvestmentSector(String investmentSector) {
        this.investmentSector = investmentSector;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }
}