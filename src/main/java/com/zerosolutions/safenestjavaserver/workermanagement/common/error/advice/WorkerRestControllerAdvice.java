package com.zerosolutions.safenestjavaserver.workermanagement.common.error.advice;

import com.zerosolutions.safenestjavaserver.workermanagement.common.error.ErrorDetails;
import com.zerosolutions.safenestjavaserver.workermanagement.common.error.exception.WorkerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WorkerRestControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WorkerNotFoundException.class)
    public ErrorDetails workerNotFoundHandler(WorkerNotFoundException e){
        return new ErrorDetails(404, "Worker with id " + e.getWorkerId() + " not found", "Choose a different worker");
    }
}
