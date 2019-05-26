package com.zerosolutions.safenestjavaserver.workermanagement.business.api;

import java.util.List;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

public interface WorkerManagement {

	public List<Worker> getAllWorkers();

    String bookWorker(long id);
}
