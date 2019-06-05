package com.zerosolutions.safenestjavaserver.jobmanagement.services.api.rest;

import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequestMapping("/v1/job")
public interface JobRestService {

    @PostMapping("/create")
    public Job createJob(String jobStartDateTime, String jobEndDateTime, long workerId);
}
