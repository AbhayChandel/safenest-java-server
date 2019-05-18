package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>  {

}
