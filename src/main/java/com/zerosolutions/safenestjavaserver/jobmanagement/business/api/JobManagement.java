package com.zerosolutions.safenestjavaserver.jobmanagement.business.api;

import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import org.springframework.stereotype.Component;

public interface JobManagement {

    public Job createJob(String jobStartDate, String jobEndDate, Long workerId);
}
