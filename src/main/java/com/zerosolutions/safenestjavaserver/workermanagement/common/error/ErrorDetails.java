package com.zerosolutions.safenestjavaserver.workermanagement.common.error;

public class ErrorDetails {

    private final int errorCode;
    private final String errorCause;
    private final String errorFix;

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
