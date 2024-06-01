package com.example.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class JobController {

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private final JobService jobService;

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String CreateJob(@RequestBody Job job)
    {
        jobService.CreateJob(job);
        return "job added succesfully" ;

    }

    @GetMapping("/jobs/{ID}")
    public ResponseEntity<Job> getJobByID(@PathVariable Long ID) {

        Job job = jobService.getJobByID(ID);
        if(job != null)
            return new ResponseEntity<>(job,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/jobs/{ID}")
    public ResponseEntity<String> deleteJob(@PathVariable Long ID){
        boolean deleted = jobService.deleteJobByID(ID);
        if(deleted)
            return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{ID}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated= jobService.updateJob(id, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
