package com.zanzibar.backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long JobSeekerId;
    private String JobSeekerName;
    private String JobSeekerEmail;
    private String JobSeekerPhone;
    private String JobSeekerAddress;
    private String Password;
    private String UploadCV;
}
