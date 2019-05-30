package com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_generator")
    @SequenceGenerator(name = "job_generator", sequenceName = "job_seq", allocationSize = 1)
    private int id;

    public Job(LocalDateTime jobStartDateTime, LocalDateTime jobEndDateTime){
        this.jobStartDateTime = jobStartDateTime;
        this.jobEndDateTime = jobEndDateTime;
    }

    public Job(){}

    @ManyToOne(optional = false)
    @JoinColumn(name = "worker_id")
    @JsonBackReference
    private Worker worker;

    @Column(name = "start_datetime")
    private LocalDateTime jobStartDateTime;

    @Column(name = "end_datetime")
    private LocalDateTime jobEndDateTime;

    public LocalDateTime getJobStartDateTime() {
        return jobStartDateTime;
    }

    public void setJobStartDateTime(LocalDateTime jobStartDateTime) {
        this.jobStartDateTime = jobStartDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return jobEndDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.jobEndDateTime = endDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
