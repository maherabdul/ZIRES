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
    private JobSeekerServices jobseekerservices;

    @PostMapping ("/create")
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker){
        return jobseekerservices.createJobSeeker(jobSeeker);
    }

    @GetMapping("/all")
    public List<JobSeeker> getAllJobSeeker(){
        return jobseekerservices.getAllJobSeekers();
    }

    @GetMapping("/JobSeeker/{id}")
    public JobSeeker getJobSeekerById(@PathVariable int id){
        return jobseekerservices.getJobSeekerById(id);
    }

    @PutMapping("update/{id}")
    public JobSeeker updateJobSeeker(@RequestBody JobSeeker jobSeeker, @PathVariable int id){
        return jobseekerservices.updateJobSeeker(jobSeeker,id)
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJobSeeker(@PathVariable int id) {
        jobseekerservices.deleteJobSeekerById(id);
    }
}
