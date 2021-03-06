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

    public Job(LocalDateTime startDateTime, LocalDateTime endDateTime, Worker worker){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.worker = worker;
    }

    public Job(){}

    @ManyToOne(optional = false)
    @JoinColumn(name = "worker_id")
    @JsonBackReference
    private Worker worker;

    @Column(name = "start_datetime")
    private LocalDateTime startDateTime;

    @Column(name = "end_datetime")
    private LocalDateTime endDateTime;

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getId() {
        return id;
    }

    public Worker getWorker() {
        return worker;
    }

}
