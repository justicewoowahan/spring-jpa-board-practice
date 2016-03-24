package com.woowahan.riders.spring.practice.exception;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public class DuplicatedUseridAlreadyExistsException extends RuntimeException {

    public DuplicatedUseridAlreadyExistsException() {
        super("occur error because board name already exists!!");
    }

}
