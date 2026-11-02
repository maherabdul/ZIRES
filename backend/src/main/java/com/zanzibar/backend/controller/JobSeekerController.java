
package com.zanzibar.backend.controller;

import com.zanzibar.backend.model.JobSeeker;
import com.zanzibar.backend.service.JobSeekerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/JobSeeker")
public class JobSeekerController {

    @Autowired
    private JobSeekerServices jobSeekerServices;

    // Create Job Seeker
    @PostMapping("/create")
    public JobSeeker createJobSeeker(
            @RequestBody JobSeeker jobSeeker) {

        return jobSeekerServices.createJobSeeker(jobSeeker);
    }

    // Get all Job Seekers
    @GetMapping("/all")
    public List<JobSeeker> getAllJobSeekers() {

        return jobSeekerServices.getAllJobSeekers();
    }

    // Get Job Seeker by ID
    @GetMapping("/{id}")
    public JobSeeker getJobSeekerById(
            @PathVariable Long id) {

        return jobSeekerServices.getJobSeekerById(id);
    }

    // Update Job Seeker
    @PutMapping("/update/{id}")
    public JobSeeker updateJobSeeker(
            @PathVariable Long id,
            @RequestBody JobSeeker jobSeeker) {

        return jobSeekerServices.updateJobSeeker(id, jobSeeker);
    }

    // Delete Job Seeker
    @DeleteMapping("/delete/{id}")
    public void deleteJobSeeker(
            @PathVariable Long id) {

        jobSeekerServices.deleteJobSeeker(id);
    }
}
