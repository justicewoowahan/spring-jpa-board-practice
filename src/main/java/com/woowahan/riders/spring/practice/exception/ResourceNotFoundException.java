package com.woowahan.riders.spring.practice.exception;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("resource does not exists!");
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
