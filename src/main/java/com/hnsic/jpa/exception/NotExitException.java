package com.hnsic.jpa.exception;

public class NotExitException extends RuntimeException {
    public NotExitException() {
        super("用户不存在");
    }
}
