package com.oumuv.exception;

public class MyException extends RuntimeException{

    private int state;//状态：1成功，0失败，-2系统超时，-1系统出错

    public MyException(String message, int state) {
        super(message);
        this.state = state;
    }

    public MyException(String message, Throwable cause, int state) {
        super(message, cause);
        this.state = state;
    }
}
