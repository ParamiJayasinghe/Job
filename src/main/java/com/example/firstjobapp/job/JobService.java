package com.example.firstjobapp.job;

import com.example.firstjobapp.job.Job;

import java.util.List;

public interface JobService {

    boolean updateJob(Long id, Job updatedJob) ;

    List<Job> findAll();

    void CreateJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobByID(Long id);
}
