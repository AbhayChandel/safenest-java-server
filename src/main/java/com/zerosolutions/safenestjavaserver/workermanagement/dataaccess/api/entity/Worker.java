package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Worker {
	
	@Id
	private long id;

	@Column(name = "is_booked")
	private boolean booked;
	
	public Worker() {}
	
	public Worker(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
}
