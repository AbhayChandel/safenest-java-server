package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

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
        assertTrue(workerRepository.findById(2L).isPresent());
    }

    @Test
    public void testCreatingWorker() {
        Worker worker = new Worker();
        worker = workerRepository.save(worker);
        assertNotEquals(Long.valueOf(0), worker.getId());
    }

    @Test
    public void testDeletingWorker() {
        Worker worker = workerRepository.findById(1L).get();
        workerRepository.delete(worker);
        assertFalse(workerRepository.findById(1L).isPresent());
    }

    @Test
    public void testSettingWorkerHasJobBookings() {
        Optional<Worker> workerOptional = workerRepository.findById(1L);
        assertTrue(workerOptional.isPresent());
        Worker worker = workerOptional.get();
        assertFalse(worker.hasBookings());
        worker.setHasBookings(true);
        worker = workerRepository.save(worker);
        assertTrue(worker.hasBookings());
    }
}
