package com.yeni.YeniSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

}
