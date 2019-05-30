package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Job;
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
		assertThat(workerList, hasSize(3));
	}

	@Test
	public void testFindWorkerById() {
		assertEquals(Long.valueOf(2), workerRepository.findById(2L).get().getId());
	}

	@Test
	public void testCreatingNewWorker(){
		Worker worker = new Worker();
		Job job = new Job(LocalDateTime.parse("2019-06-01T07:00:00"), LocalDateTime.parse("2019-06-02T19:00:00"));
		List<Job> bookedJobs = new ArrayList<>();
		bookedJobs.add(job);
		worker.setBookedJobs(bookedJobs);
		worker = workerRepository.save(worker);
		assertNotEquals(Long.valueOf(0), worker.getId());
	}

	@Test
	public void testUpdateExistingWorker(){
		Worker worker = workerRepository.findById(1L).get();
		List<Job> bookedJobs = worker.getBookedJobs();
		assertThat(bookedJobs, hasSize(0));
		Job newJob = new Job(LocalDateTime.parse("2019-06-05T07:00:00"), LocalDateTime.parse("2019-06-06T19:00:00"));
		bookedJobs.add(newJob);
		worker.setBookedJobs(bookedJobs);
		worker = workerRepository.save(worker);
		assertThat(workerRepository.findById(1L).get().getBookedJobs(), hasSize(1));
	}

	@Test
	public void testDeletingWorker(){
		Worker worker = workerRepository.findById(1L).get();
		workerRepository.delete(worker);
		assertFalse(workerRepository.findById(1L).isPresent());
	}

	@Test
	public void testSettingWorkerHasJobBookings(){
		Worker worker = workerRepository.findById(1L).get();
		assertFalse(worker.hasBookings());
		worker.setHasBookings(true);
		worker = workerRepository.save(worker);
		assertTrue(worker.hasBookings());
	}

	@Test
	public void testGettingWorkerJobBookings(){
		Worker worker = workerRepository.findById(2L).get();
		List<Job> jobsBooked = worker.getBookedJobs();
		assertThat(jobsBooked, hasSize(2));
	}

	@Test
	public void testNoJobBookingsFound(){
		Worker worker = workerRepository.findById(3L).get();
		List<Job> jobsBooked = worker.getBookedJobs();
		assertThat(jobsBooked, hasSize(0));
	}
}
