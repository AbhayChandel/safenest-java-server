package com.zerosolutions.safenestjavaserver.workermanagement.common.error.exception;

public class WorkerNotFoundException extends RuntimeException {

    private long workerId;

    public WorkerNotFoundException(long workerId){
        this.workerId = workerId;
    }

    public long getWorkerId(){
        return workerId;
    }

}
