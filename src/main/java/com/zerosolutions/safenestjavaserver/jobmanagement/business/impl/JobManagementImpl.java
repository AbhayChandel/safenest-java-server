package com.zerosolutions.safenestjavaserver.jobmanagement.business.impl;

import com.zerosolutions.safenestjavaserver.jobmanagement.business.api.JobManagement;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.repository.JobRepository;
import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class JobManagementImpl implements JobManagement {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    WorkerManagement workerManagement;

    @Override
    public Job createJob(String jobStartDate, String jobEndDate, Long workerId) {
        LocalDateTime startDateTime = LocalDateTime.parse(jobStartDate);
        LocalDateTime endDateTime = LocalDateTime.parse(jobEndDate);
        Worker worker = workerManagement.findWorkerById(workerId);
        return jobRepository.save(new Job(startDateTime, endDateTime, worker));
    }
}
