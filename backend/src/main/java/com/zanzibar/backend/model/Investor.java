package com.zanzibar.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long investorId;
    private String investorName;
    private String postJobs;
    private String investorProfile;
    private String scheduleInterview;
    private String hireEmployees;

}
