package com.system.user.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
