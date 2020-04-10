package com.rpolnx.travel.common.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
