package com.huawei.nce.javabase.day16.exceptionhandling;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 17:44
 */
public class EcmDefException extends  RuntimeException{
    static final long serialVersionUID = 2262992169377396207L;

    public EcmDefException () {
        super();
    }

    public EcmDefException (String message) {
        super(message);
    }

    public EcmDefException (String message, Throwable throwable) {
        super(message,throwable);
    }
}
