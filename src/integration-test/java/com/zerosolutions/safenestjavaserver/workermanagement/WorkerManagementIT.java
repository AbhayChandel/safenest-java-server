package com.zerosolutions.safenestjavaserver.workermanagement;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkerManagementIT {

	@Autowired
	ObjectMapper objectMapper;
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void testGetAllWorkers() throws Exception {
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/v1/worker/getall", String.class);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
		List<Worker> workerList = this.objectMapper.readValue(responseEntity.getBody(), List.class);
		assertThat(workerList, hasSize(2));
	}

	@Test
	public void testWorkerBookingSuccessful() throws Exception{
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/v1/worker/book/1", String.class);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
		assertEquals("Worker booked successfully.", responseEntity.getBody());
	}
}
