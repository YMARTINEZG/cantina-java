package com.exercise.cantinajava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong payload")
public class BadPayloadException extends Exception{
    private static final long serialVersionUID = 1L;

    public BadPayloadException(String message) {
        super(message);
    }
}
