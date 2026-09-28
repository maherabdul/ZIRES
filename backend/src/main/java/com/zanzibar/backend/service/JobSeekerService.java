package com.example.backend.service;

import com.example.backend.model.JobSeeker;
import com.example.backend.model.User;
import com.example.backend.repository.JobSeekerRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;
    private final UserRepository userRepository;

    public JobSeekerService(
            JobSeekerRepository jobSeekerRepository,
            UserRepository userRepository) {

        this.jobSeekerRepository = jobSeekerRepository;
        this.userRepository = userRepository;
    }

    // Create JobSeeker
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {

        Long userId = jobSeeker.getUser().getUserId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        jobSeeker.setUser(user);

        return jobSeekerRepository.save(jobSeeker);
    }

    // Get all JobSeekers
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    // Get JobSeeker by ID
    public JobSeeker getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id).orElse(null);
    }

    // Update JobSeeker
    public JobSeeker updateJobSeeker(Long id, JobSeeker jobSeeker) {

        JobSeeker existingJobSeeker =
                jobSeekerRepository.findById(id).orElse(null);

        if (existingJobSeeker == null) {
            return null;
        }

        Long userId = jobSeeker.getUser().getUserId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingJobSeeker.setUser(user);
        existingJobSeeker.setGender(jobSeeker.getGender());
        existingJobSeeker.setDateOfBirth(jobSeeker.getDateOfBirth());
        existingJobSeeker.setEducation(jobSeeker.getEducation());
        existingJobSeeker.setExperience(jobSeeker.getExperience());
        existingJobSeeker.setSkills(jobSeeker.getSkills());
        existingJobSeeker.setCv(jobSeeker.getCv());
        existingJobSeeker.setDistrict(jobSeeker.getDistrict());

        return jobSeekerRepository.save(existingJobSeeker);
    }

    // Delete JobSeeker
    public void deleteJobSeeker(Long id) {
        jobSeekerRepository.deleteById(id);
    }
}