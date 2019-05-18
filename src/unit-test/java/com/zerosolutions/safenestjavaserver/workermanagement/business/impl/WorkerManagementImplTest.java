package com.zerosolutions.safenestjavaserver.workermanagement.business.impl;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository.WorkerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerManagementImplTest {

	@Autowired
	WorkerManagement workerManagement;

	@MockBean
	WorkerRepository workerRepository;

	@Test
	public void testGetAllNannies() {

		List<Worker> workers = new ArrayList<Worker>();
		workers.add(new Worker(1L));
		workers.add(new Worker(2L));
		when(this.workerRepository.findAll()).thenReturn(workers);
		List<Worker> workerList = workerManagement.getAllWorkers();
		assertThat(workerList, hasSize(2));
	}
}
