package com.sinacolada.tiki.util.custom.exception;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String msg) {
        super(msg);
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}