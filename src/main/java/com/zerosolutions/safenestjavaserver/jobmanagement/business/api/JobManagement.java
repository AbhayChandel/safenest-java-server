package com.zerosolutions.safenestjavaserver.jobmanagement.business.api;

import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;

public interface JobManagement {

    Job createJob(String jobStartDate, String jobEndDate, Long workerId);
}
