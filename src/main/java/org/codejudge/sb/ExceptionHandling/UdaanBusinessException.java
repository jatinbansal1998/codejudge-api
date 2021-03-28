package org.codejudge.sb.ExceptionHandling;

public class UdaanBusinessException extends RuntimeException {
    public UdaanBusinessException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public UdaanBusinessException(String errorMessage) {
        super(errorMessage);
    }
}
