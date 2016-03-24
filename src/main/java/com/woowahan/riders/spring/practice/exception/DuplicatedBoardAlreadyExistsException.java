package com.woowahan.riders.spring.practice.exception;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public class DuplicatedBoardAlreadyExistsException extends RuntimeException {

    public DuplicatedBoardAlreadyExistsException() {
        super("occur error because userid already exists!!");
    }

    public DuplicatedBoardAlreadyExistsException(String msg) {
        super(msg);
    }

    public DuplicatedBoardAlreadyExistsException(String msg, Throwable t) {
        super(msg, t);
    }
}
