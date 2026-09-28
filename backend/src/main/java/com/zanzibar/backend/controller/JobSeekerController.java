package com.example.backend.controller;

import com.example.backend.model.JobSeeker;
import com.example.backend.service.JobSeekerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    // Create JobSeeker
    @PostMapping
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerService.createJobSeeker(jobSeeker);
    }

    // Get all JobSeekers
    @GetMapping
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerService.getAllJobSeekers();
    }

    // Get JobSeeker by ID
    @GetMapping("/{id}")
    public JobSeeker getJobSeekerById(@PathVariable Long id) {
        return jobSeekerService.getJobSeekerById(id);
    }

    // Update JobSeeker
    @PutMapping("/{id}")
    public JobSeeker updateJobSeeker(
            @PathVariable Long id,
            @RequestBody JobSeeker jobSeeker) {

        return jobSeekerService.updateJobSeeker(id, jobSeeker);
    }

    // Delete JobSeeker
    @DeleteMapping("/{id}")
    public String deleteJobSeeker(@PathVariable Long id) {

        jobSeekerService.deleteJobSeeker(id);

        return "JobSeeker deleted successfully";
    }
}