package com.zerosolutions.safenestjavaserver.workermanagement.services.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

@RequestMapping("/v1/worker")
public interface WorkerRestService {

	@GetMapping("/getall")
	public List<Worker> getAllWorkers();

	@GetMapping("/book/{id}")
	public String bookWorker(@PathVariable int id);

}
