package com.zerosolutions.safenestjavaserver.workermanagement.business.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Job;
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

    private Worker saveJob(Worker worker, String startDateTime, String endDateTime) {
        List<Job> bookedJobs = worker.getBookedJobs();
        Job job = new Job(LocalDateTime.parse(startDateTime), LocalDateTime.parse(endDateTime));
        bookedJobs.add(job);
        worker.setBookedJobs(bookedJobs);
        worker.setHasBookings(true);
        return workerRepository.save(worker);
    }

    private boolean doesBookingDatesConflictWithExistingBookings(List<Job> bookedJobs, String bookingStartDateTime, String bookingEndDateTime) {
        for (Job job : bookedJobs) {
            LocalDateTime dateTime;
            if ((!LocalDateTime.parse(bookingStartDateTime).isBefore(job.getJobStartDateTime()) && !LocalDateTime.parse(bookingStartDateTime).isAfter(job.getEndDateTime())) ||
                    (!LocalDateTime.parse(bookingEndDateTime).isBefore(job.getJobStartDateTime()) && !LocalDateTime.parse(bookingEndDateTime).isAfter(job.getEndDateTime()))) {
                return true;
            }
        }
        return false;
    }

}
