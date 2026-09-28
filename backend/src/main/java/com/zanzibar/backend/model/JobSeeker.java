package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seekerId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private com.example.backend.model.User user;

    private String gender;

    private LocalDate dateOfBirth;

    private String education;

    private String experience;

    private String skills;

    private String cv;

    private String district;
}