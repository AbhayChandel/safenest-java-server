package com.zerosolutions.safenestjavaserver.jobmanagement.business.impl;


import com.zerosolutions.safenestjavaserver.jobmanagement.business.api.JobManagement;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.repository.JobRepository;
import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobManagementImplTest {

    @Autowired
    JobManagement jobManagement;

    @MockBean
    JobRepository jobRepository;

    @MockBean
    WorkerManagement workerManagement;

    @Test
    public void testCreatingJob(){
        Job job = new Job(LocalDateTime.parse("2019-06-10T08:00"), LocalDateTime.parse("2019-06-12T20:00"), new Worker(1L));
        when(jobRepository.save(ArgumentMatchers.any())).thenReturn(job);
        Job jobReturned = jobManagement.createJob("2019-06-10T08:00", "2019-06-12T20:00", 1L);
        assertEquals(LocalDateTime.of(LocalDate.of(2019, 06, 10), LocalTime.of(8, 0)), jobReturned.getStartDateTime());
        assertEquals(LocalDateTime.of(LocalDate.of(2019, 06, 12), LocalTime.of(20, 0)), jobReturned.getEndDateTime());
        assertEquals(Long.valueOf(1), jobReturned.getWorker().getId());

    }

}
