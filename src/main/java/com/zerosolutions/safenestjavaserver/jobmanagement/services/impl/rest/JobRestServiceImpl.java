package com.zerosolutions.safenestjavaserver.jobmanagement.services.impl.rest;

import com.zerosolutions.safenestjavaserver.jobmanagement.business.api.JobManagement;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import com.zerosolutions.safenestjavaserver.jobmanagement.services.api.rest.JobRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRestServiceImpl implements JobRestService {

    private final JobManagement jobManagement;

    @Autowired
    public JobRestServiceImpl(JobManagement jobManagement) {
        this.jobManagement = jobManagement;
    }

    @Override
    public Job createJob(@RequestParam("jobStartDateTime") String jobStartDateTime, @RequestParam("jobEndDateTime") String jobEndDateTime, @RequestParam("workerId") long workerId) {
        return this.jobManagement.createJob(jobStartDateTime, jobEndDateTime, workerId);
    }
}
