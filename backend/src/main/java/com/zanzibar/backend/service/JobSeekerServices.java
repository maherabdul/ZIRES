package com.zanzibar.backend.service;

import com.zanzibar.backend.model.JobSeeker;
import com.zanzibar.backend.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobSeekerServices {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeeker findById(Integer id) {
        return jobSeekerRepository.findById(id).get();
    }

   public  List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
   }

   public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(JobSeeker);
   }

   public JobSeeker updateJobSeeker(Long id,JobSeeker jobSeeker) {
        JobSeeker existingJobSeeker = jobSeekerRepository.findById(id).orElse(null);
        if (existingJobSeeker != null) {
            existingJobSeeker.setName(jobSeeker.getName());
            return jobSeekerRepository.save(existingJobSeeker);
        }
        return null;
        }
   }
}
