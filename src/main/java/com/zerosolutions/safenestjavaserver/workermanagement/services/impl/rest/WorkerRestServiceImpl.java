package com.zerosolutions.safenestjavaserver.workermanagement.services.impl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zerosolutions.safenestjavaserver.workermanagement.business.api.WorkerManagement;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;
import com.zerosolutions.safenestjavaserver.workermanagement.services.api.rest.WorkerRestService;

@RestController
public class WorkerRestServiceImpl implements WorkerRestService {

	@Autowired
	WorkerManagement workerManagement;
	
	public List<Worker> getAllWorkers(){
		return workerManagement.getAllWorkers(); 
	}

	@Override
	public String bookWorker(int id) {
		return this.workerManagement.bookWorker(id);
	}
}
