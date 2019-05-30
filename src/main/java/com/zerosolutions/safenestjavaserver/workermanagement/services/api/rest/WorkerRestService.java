package com.zerosolutions.safenestjavaserver.workermanagement.services.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;


@RequestMapping("/v1/worker")
public interface WorkerRestService {

	@GetMapping("/")
	public List<Worker> getAllWorkers();

	@GetMapping("/{id}")
	public Worker getOneWorker(@PathVariable("id") long id);

	@PostMapping("/create")
	public Worker createWorker();

}
