package com.zanzibar.backend.service;

import com.zanzibar.backend.model.JobSeeker;
import com.zanzibar.backend.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobSeekerServices {
    @Autowired
    private JobSeekerRepository jobseekerrepository;

    public JobSeeker findById(Integer id) {
        return jobseekerrepository.findById(id).orElse(null);
    }

   public  List<JobSeeker> getAllJobSeekers() {
        return jobseekerrepository.findAll();
   }

   public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobseekerrepository.save(JobSeeker);
   }

   public JobSeeker updateJobSeeker(Long id,JobSeeker jobSeeker) {
        JobSeeker existingJobSeeker = jobseekerrepository.findById(id).orElse(null);
        if (existingJobSeeker != null) {
            existingJobSeeker.setName(jobSeeker.getName());
            return jobseekerrepository.save(existingJobSeeker);
        }
        return null;
        }

   public void deleteJobSeeker(Long id) {
        jobseekerrepository.deleteById(id);
   }
}

