package com.zerosolutions.safenestjavaserver.workermanagement.services.impl.rest;

import static org.mockito.Mockito.when;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

@RunWith(SpringRunner.class)
@WebMvcTest(WorkerRestServiceImpl.class)
public class WorkerRestServiceImplTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	WorkerManagement workerManagement;

	@Test
	public void testFindAllWorkers() throws Exception {
		List<Worker> workers = new ArrayList<Worker>();
		workers.add(new Worker(1L));
		workers.add(new Worker(2L));
		when(this.workerManagement.getAllWorkers()).thenReturn(workers);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/worker/getall")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	public void testWorkerBookedSuccessMessageIsReturned() throws Exception {
		when(this.workerManagement.bookWorker(1)).thenReturn("Worker booked successfully.");
		this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/worker/book/1")).andExpect(status().isOk())
				.andExpect(content().string("Worker booked successfully."));
	}



}
