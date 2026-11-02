package com.zanzibar.backend.service;

import com.zanzibar.backend.model.JobSeeker;
import com.zanzibar.backend.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerServices {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    // Create Job Seeker
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    // Get all Job Seekers
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    // Get Job Seeker by ID
    public JobSeeker getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id).orElse(null);
    }

    // Update Job Seeker
    public JobSeeker updateJobSeeker(Long id, JobSeeker jobSeeker) {

        JobSeeker existingJobSeeker =
                jobSeekerRepository.findById(id).orElse(null);

        if (existingJobSeeker != null) {

            existingJobSeeker.setJobSeekerName(
                    jobSeeker.getJobSeekerName());

            existingJobSeeker.setJobSeekerEmail(
                    jobSeeker.getJobSeekerEmail());

            existingJobSeeker.setJobSeekerPhone(
                    jobSeeker.getJobSeekerPhone());

            existingJobSeeker.setJobSeekerAddress(
                    jobSeeker.getJobSeekerAddress());

            existingJobSeeker.setPassword(
                    jobSeeker.getPassword());

            existingJobSeeker.setUploadCV(
                    jobSeeker.getUploadCV());

            return jobSeekerRepository.save(existingJobSeeker);
        }

        return null;
    }

    // Delete Job Seeker
    public void deleteJobSeeker(Long id) {
        jobSeekerRepository.deleteById(id);
    }
}
