package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zerosolutions.safenestjavaserver.jobmanagement.dataaccess.api.entity.Job;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_generator")
    @SequenceGenerator(name = "worker_generator", sequenceName = "worker_seq", allocationSize = 1)
    private long id;

    @Column(name = "booked")
    private boolean hasBookings;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Job> bookedJobs;

    public Worker() {
    }

    public Worker(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean hasBookings() {
        return hasBookings;
    }

    public void setHasBookings(boolean hasBookings) {
        this.hasBookings = hasBookings;
    }

    public List<Job> getBookedJobs() {
        return bookedJobs;
    }

    public void setBookedJobs(List<Job> bookedJobs) {
        this.bookedJobs = bookedJobs;
    }
}
