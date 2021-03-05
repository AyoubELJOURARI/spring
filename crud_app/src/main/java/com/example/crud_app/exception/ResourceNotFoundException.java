package com.example.crud_app.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {

    public static final long serialVersionUID = 1l;



    public ResourceNotFoundException(String message) {
    	super(message);
}

    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }


}
