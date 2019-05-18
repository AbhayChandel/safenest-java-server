package com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Worker {
	
	@Id
	private long id;
	
	public Worker() {}
	
	public Worker(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}
