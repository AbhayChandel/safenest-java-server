package com.zerosolutions.safenestjavaserver.workermanagement.common.error;

public class ErrorDetails {

    private int errorCode;
    private String errorCause;
    private String errorFix;

    public ErrorDetails(int errorCode, String errorCause, String errorFix){
        this.errorCode = errorCode;
        this.errorCause = errorCause;
        this.errorFix = errorFix;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorCause() {
        return errorCause;
    }

    public String getErrorFix() {
        return errorFix;
    }
}
