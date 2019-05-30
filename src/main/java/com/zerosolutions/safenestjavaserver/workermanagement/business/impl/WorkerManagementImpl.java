package com.zerosolutions.safenestjavaserver.workermanagement.business.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository.WorkerRepository;

@Component
public class WorkerManagementImpl implements WorkerManagement {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findWorkerById(long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return worker.orElse(null);
        //TO-DO Throw CustomerNotFoundException;
    }

    @Override
    public Worker createWorker() {
        Worker worker = new Worker();
        return workerRepository.save(worker);
    }
}
