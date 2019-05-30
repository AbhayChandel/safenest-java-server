package com.zerosolutions.safenestjavaserver.workermanagement.business.api;

import java.util.List;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

public interface WorkerManagement {

	public List<Worker> findAllWorkers();

    public Worker findWorkerById(long id);

    public Worker createWorker();
}
