package com.qupeng.optional;

public class ResultObject {

    private Integer errorCode;

    private String errorMessage;

    private Object object;

    public ResultObject(Integer errorCode, String errorMessage, Object object) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.object = object;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
