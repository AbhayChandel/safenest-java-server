package com.zerosolutions.safenestjavaserver.workermanagement.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.common.api.to.WorkerTO;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository.WorkerRepository;

@Component
public class WorkerManagementImpl implements WorkerManagement {
	
	@Autowired
	WorkerRepository workerRepository;

	@Override
	public List<Worker> getAllWorkers() {
		return workerRepository.findAll();
	}

}
