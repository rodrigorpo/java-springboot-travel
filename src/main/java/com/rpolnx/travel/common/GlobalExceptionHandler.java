package com.rpolnx.travel.common;

import com.rpolnx.travel.common.exceptions.BadRequestException;
import com.rpolnx.travel.common.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BadRequestException handleBadRequest(BadRequestException ex) {
        return ex;
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundException handleNotFound(NotFoundException ex) {
        return ex;
    }
}
