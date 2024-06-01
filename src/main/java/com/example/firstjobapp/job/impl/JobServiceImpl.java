package com.example.firstjobapp.job.impl;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();

    private long nextID = 1L;

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (Job job:jobs) {
           if (job.getId().equals(id)) {
               job.setTitle(updatedJob.getTitle());
               job.setDescription(updatedJob.getDescription());
               job.setMinSalary(updatedJob.getMinSalary());
               job.setMaxSalary(updatedJob.getMaxSalary());
               job.setLocation(updatedJob.getLocation());
               return true;
           }
        }
        return false;
    }

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void CreateJob() {

    }

    @Override
    public void CreateJob(Job job) {

        job.setId(nextID++);
        jobs.add(job);

    }

    @Override
    public Job getJobByID(Long ID) {
        for (Job job:
             jobs) {
            if(job.getId().equals(ID)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobByID(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;

    }


}
