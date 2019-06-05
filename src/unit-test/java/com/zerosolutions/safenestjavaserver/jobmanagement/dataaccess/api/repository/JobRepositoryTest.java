package com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.repository;

import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JobRepositoryTest {

    @Autowired
    JobRepository jobRepository;

    @Test
    public void testCreatingJob() {
        Job job = jobRepository.save(new Job(LocalDateTime.of(LocalDate.of(2019, 6, 12), LocalTime.of(20, 0)), LocalDateTime.of(LocalDate.of(2019, 6, 14), LocalTime.of(20, 0)), new Worker(10L)));
        assertTrue(job.getId() > 0);
    }
}
