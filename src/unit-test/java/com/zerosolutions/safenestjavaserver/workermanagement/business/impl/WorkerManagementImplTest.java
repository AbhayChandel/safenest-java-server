package com.zerosolutions.safenestjavaserver.workermanagement.business.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zerosolutions.safenestjavaserver.workermanagement.common.error.exception.WorkerNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
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
    public void testGetAllWorkers() {

        List<Worker> workers = new ArrayList<Worker>();
        workers.add(new Worker(1L));
        workers.add(new Worker(2L));
        when(this.workerRepository.findAll()).thenReturn(workers);
        List<Worker> workerList = workerManagement.findAllWorkers();
        assertThat(workerList, hasSize(2));
    }

    @Test
    public void testFindWorkerById() {
        Worker worker = new Worker(1L);
        when(this.workerRepository.findById(1L)).thenReturn(Optional.of(worker));
        assertEquals(Long.valueOf(1), workerManagement.findWorkerById(1L).getId());
    }

    @Test(expected = WorkerNotFoundException.class)
    public void testWorkerNotFound() throws Exception {
        when(this.workerRepository.findById(10L)).thenReturn(Optional.empty());
        workerManagement.findWorkerById(10L);
    }

    @Test
    public void testCreatingNewWorker() {
        Worker returnedWorker = new Worker(5L);
        when(this.workerRepository.save(ArgumentMatchers.any())).thenReturn(returnedWorker);
        Worker worker = this.workerManagement.createWorker();
        assertEquals(Long.valueOf(5), worker.getId());

    }
}