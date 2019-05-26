package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkerRepositoryTest {

	@Autowired
	WorkerRepository workerRepository;
	
	@Test
	public void testFindAll() {
		List<Worker> workerList = workerRepository.findAll();
		assertThat(workerList, hasSize(2));
	}

	@Test
	public void testWorkerBooked(){
		Worker worker = workerRepository.getOne(1L);
		assertFalse(worker.isBooked());
		worker.setBooked(true);
		worker = workerRepository.save(worker);
		assertTrue(worker.isBooked());
	}
}
