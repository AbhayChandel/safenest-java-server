package com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.repository;

import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
