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

    @PostMapping ("/create")
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker){
        return jobSeekerServices.createJobSeeker(jobSeeker);
    }

    @GetMapping("/all")
    public List<JobSeeker> getAllJobSeeker(){
        return jobSeekerServices.getAllJobSeekers();
    }

    @GetMapping("/JobSeeker/{id}")
    public JobSeeker getJobSeekerById(@PathVariable int id){
        return jobSeekerServices.getJobSeekerById(id);
    }

    @PutMapping("update/{id}")
    public JobSeeker updateJobSeeker(@RequestBody JobSeeker jobSeeker, @PathVariable int id){
        return jobSeekerServices.updateJobSeeker(id,jobSeeker)
    }
}
