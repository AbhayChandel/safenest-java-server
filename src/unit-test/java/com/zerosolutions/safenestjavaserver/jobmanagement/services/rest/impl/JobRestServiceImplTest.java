package com.zerosolutions.safenestjavaserver.jobmanagement.services.rest.impl;

import com.zerosolutions.safenestjavaserver.jobmanagement.business.api.JobManagement;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import com.zerosolutions.safenestjavaserver.jobmanagement.services.impl.rest.JobRestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JobRestServiceImpl.class)
public class JobRestServiceImplTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private JobManagement jobManagement;

    @Test
    public void testCreatingNewJob() throws Exception {
        Job job = new Job(LocalDateTime.parse("2019-06-10T08:00:00"), LocalDateTime.parse("2019-06-12T20:00:00"), null);
        when(this.jobManagement.createJob("2019-06-10T08:00:00", "2019-06-12T20:00:00", 1L)).thenReturn(job);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/job/create").param("jobStartDateTime", "2019-06-10T08:00:00").param("jobEndDateTime", "2019-06-12T20:00:00").param("workerId", "1"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.startDateTime").value("2019-06-10T08:00:00"))
                .andExpect(jsonPath("$.endDateTime").value("2019-06-12T20:00:00"));
    }
}
