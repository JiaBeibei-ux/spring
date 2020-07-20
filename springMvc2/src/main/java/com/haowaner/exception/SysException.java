package com.haowaner.exception;

/**
 * 自定义异常
 */
public class SysException extends Exception{
    private String msg;//用于存储信息的

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SysException(String msg) {
        this.msg = msg;
    }
}
